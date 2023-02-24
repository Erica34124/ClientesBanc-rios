package com.clientesbanco.repository;

import com.clientesbanco.domain.Clientes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientesRepository extends MongoRepository<Clientes, String> {
}
