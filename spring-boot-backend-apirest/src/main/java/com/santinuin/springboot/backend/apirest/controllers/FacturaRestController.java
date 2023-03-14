package com.santinuin.springboot.backend.apirest.controllers;

import com.santinuin.springboot.backend.apirest.models.entity.Factura;
import com.santinuin.springboot.backend.apirest.models.entity.Producto;
import com.santinuin.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    private final IClienteService clienteService;

    public FacturaRestController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(path = "/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura show(@PathVariable Long id){
        return  clienteService.findFacturaById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(path = "/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.deleteFacturaById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping(path = "/facturas/filtrar-productos/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String term){
        return clienteService.findProductoByNombre(term);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(path = "/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura){
        return clienteService.saveFactura(factura);
    }
}
