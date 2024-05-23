package com.rdr.sglserverjava.shared;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <T extends BaseModel> extends JpaRepository<T, KeyModel> {
    
    Page<T> findByTenantIdOrderByNome(Long tenantId, PageRequest PageRequest);
    Optional<T> findByTenantIdAndId(Long tenantId, Long id);

}
