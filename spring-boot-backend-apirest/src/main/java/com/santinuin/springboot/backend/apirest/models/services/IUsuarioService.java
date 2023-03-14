package com.santinuin.springboot.backend.apirest.models.services;

import com.santinuin.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
