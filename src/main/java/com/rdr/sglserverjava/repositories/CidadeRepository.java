package com.rdr.sglserverjava.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.sglserverjava.models.CidadeModel;

//@Repository //nao seria necessario pq o JpaRepository já herda
public interface CidadeRepository extends JpaRepository<CidadeModel, UUID>{}