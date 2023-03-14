package com.clientesbanco.repository;

import com.clientesbanco.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientesRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByCpf(String cpf);
}
