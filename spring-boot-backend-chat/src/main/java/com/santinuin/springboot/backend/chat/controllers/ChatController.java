package com.santinuin.springboot.backend.chat.controllers;

import com.santinuin.springboot.backend.chat.models.documents.Mensaje;
import com.santinuin.springboot.backend.chat.models.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ChatController {

    private String[] colores = {"red", "green", "blue", "magenta", "purple", "orange"};
    private final ChatService chatService;
    private final SimpMessagingTemplate webSocket;

    public ChatController(ChatService chatService, SimpMessagingTemplate webSocket) {
        this.chatService = chatService;
        this.webSocket = webSocket;
    }

    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje(Mensaje mensaje){
        mensaje.setFecha(new Date().getTime());

        if(mensaje.getTipo().equals("NUEVO_USUARIO")){
            mensaje.setColor(colores[new Random().nextInt(colores.length)]);
            mensaje.setTexto("nuevo usuario");
        } else{
            chatService.guardar(mensaje);
        }

        return mensaje;
    }

    @MessageMapping("/escribiendo")
    @SendTo("/chat/escribiendo")
    public String estaEscribiendo(String username){
        return username.concat(" está escribiendo ...");
    }

    @MessageMapping("/historial")
    public void  historial(String clienteId){
        webSocket.convertAndSend("/chat/historial/" + clienteId, chatService.obtenerUltimos10Mensajes());
    }


}
