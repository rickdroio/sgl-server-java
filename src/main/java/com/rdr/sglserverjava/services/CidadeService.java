package com.rdr.sglserverjava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rdr.sglserverjava.dtos.CidadeDto;
import com.rdr.sglserverjava.models.Cidade;
import com.rdr.sglserverjava.repositories.CidadeRepository;
import com.rdr.sglserverjava.security.TenantContext;

@Service
public class CidadeService {

    CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade findById(Long id) {
        var item = cidadeRepository.findByTenantIdAndId(TenantContext.getTenantId(), id);
        System.err.println(item);
        if (!item.isEmpty())
            return item.get();
        else
            return null;
    }

    public Page<Cidade> findAllPagination(int offset, int pageSize) {
         return cidadeRepository.findByTenantId(
            TenantContext.getTenantId(),
            PageRequest.of(offset, pageSize)
        ); 
    }    

    public Cidade create(CidadeDto cidadeDto) {
        var cidadeModel = new Cidade();
        BeanUtils.copyProperties(cidadeDto, cidadeModel);

        cidadeModel.setTenantId(TenantContext.getTenantId());

        return cidadeRepository.save(cidadeModel);
    }

    public Cidade update(CidadeDto cidadeDto) {
        var cidadeModel = findById(cidadeDto.id());
        BeanUtils.copyProperties(cidadeDto, cidadeModel);

        //cidadeModel.setTenantId(TenantContext.getTenantId());

        return cidadeRepository.save(cidadeModel);
    }

    public List<Cidade> saveBatch(List<CidadeDto> items) {
        List<Cidade> response = new ArrayList<>();
        
        for (CidadeDto item : items) {
            
            if (item.id() != null &&  item.id() > 0) {
                response.add(update(item));
            }
            else {
                response.add(create(item));
            }
        }

        return response;
    }    
    
}
