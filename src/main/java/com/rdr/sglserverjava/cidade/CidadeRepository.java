package com.rdr.sglserverjava.cidade;

import com.rdr.sglserverjava.shared.BaseRepository;

//@Repository //nao seria necessario pq o JpaRepository já herda
/* public interface CidadeRepository extends JpaRepository<Cidade, KeyModel>{

    Page<Cidade> findByTenantIdOrderByNome(Long tenantId, PageRequest PageRequest);
    //CidadeModel findById(Long tenantId, Long id);

    Optional<Cidade> findByTenantIdAndId(Long tenantId, Long id);

} */
public interface CidadeRepository extends BaseRepository<Cidade>{}