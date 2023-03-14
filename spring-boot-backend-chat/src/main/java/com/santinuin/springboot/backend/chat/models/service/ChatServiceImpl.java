package com.santinuin.springboot.backend.chat.models.service;

import com.santinuin.springboot.backend.chat.models.dao.ChatRepository;
import com.santinuin.springboot.backend.chat.models.documents.Mensaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatRepository chatDao;

    public ChatServiceImpl(ChatRepository chatDao) {
        this.chatDao = chatDao;
    }

    @Override
    public List<Mensaje> obtenerUltimos10Mensajes() {
        return chatDao.findFirst10ByOrderByFechaDesc();
    }

    @Override
    public Mensaje guardar(Mensaje mensaje) {
        return chatDao.save(mensaje);
    }


}
