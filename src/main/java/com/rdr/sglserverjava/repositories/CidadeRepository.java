package com.rdr.sglserverjava.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.sglserverjava.models.Cidade;
import com.rdr.sglserverjava.models.KeyModel;
import java.util.Optional;


//@Repository //nao seria necessario pq o JpaRepository já herda
public interface CidadeRepository extends JpaRepository<Cidade, KeyModel>{

    Page<Cidade> findByTenantId(Long tenantId, PageRequest PageRequest);
    //CidadeModel findById(Long tenantId, Long id);

    Optional<Cidade> findByTenantIdAndId(Long tenantId, Long id);

}