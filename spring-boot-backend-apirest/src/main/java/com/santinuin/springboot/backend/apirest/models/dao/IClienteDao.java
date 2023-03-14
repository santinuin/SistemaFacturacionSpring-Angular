package com.santinuin.springboot.backend.apirest.models.dao;

import com.santinuin.springboot.backend.apirest.models.entity.Cliente;
import com.santinuin.springboot.backend.apirest.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    public List<Region> findAllRegiones();

}
