package com.rdr.sglserverjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.sglserverjava.models.CidadeModel;
import com.rdr.sglserverjava.models.KeyModel;

//@Repository //nao seria necessario pq o JpaRepository já herda
public interface CidadeRepository extends JpaRepository<CidadeModel, KeyModel>{}