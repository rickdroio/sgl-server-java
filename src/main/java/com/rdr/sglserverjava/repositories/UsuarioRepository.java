package com.rdr.sglserverjava.repositories;

import java.util.Optional;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.sglserverjava.models.Usuario;


//@Repository //nao seria necessario pq o JpaRepository já herda
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

    Optional<Usuario> findByEmail(String email);
}