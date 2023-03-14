package com.santinuin.springboot.backend.chat.models.dao;


import com.santinuin.springboot.backend.chat.models.documents.Mensaje;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Mensaje, String> {

    public List<Mensaje> findFirst10ByOrderByFechaDesc();

}
