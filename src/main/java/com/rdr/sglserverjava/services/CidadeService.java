package com.rdr.sglserverjava.services;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rdr.sglserverjava.dtos.CidadeDto;
import com.rdr.sglserverjava.models.CidadeModel;
import com.rdr.sglserverjava.repositories.CidadeRepository;
import com.rdr.sglserverjava.security.TenantContext;

@Service
public class CidadeService {

    CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public CidadeModel save(CidadeDto cidadeDto) {
        var cidadeModel = new CidadeModel();
        BeanUtils.copyProperties(cidadeDto, cidadeModel);

        cidadeModel.setTenantId(TenantContext.getTenantId());

        return cidadeRepository.save(cidadeModel);
    }

    public Page<CidadeModel> findAllPagination(int offset, int pageSize) {
        return cidadeRepository.findAll(PageRequest.of(offset, pageSize));
    }
    
}
