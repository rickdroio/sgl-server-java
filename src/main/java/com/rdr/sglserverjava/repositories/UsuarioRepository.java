package com.rdr.sglserverjava.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.sglserverjava.models.UsuarioModel;


//@Repository //nao seria necessario pq o JpaRepository já herda
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID>{

    Optional<UsuarioModel> findByEmail(String email);
}