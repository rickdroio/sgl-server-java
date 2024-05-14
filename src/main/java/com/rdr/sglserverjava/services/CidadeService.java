package com.rdr.sglserverjava.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rdr.sglserverjava.dtos.CidadeDto;
import com.rdr.sglserverjava.models.CidadeModel;
import com.rdr.sglserverjava.repositories.CidadeRepository;

@Service
public class CidadeService {

    CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public CidadeModel save(CidadeDto cidadeDto) {
        var cidadeModel = new CidadeModel();
        BeanUtils.copyProperties(cidadeDto, cidadeModel);
        return cidadeRepository.save(cidadeModel);
    }

    public List<CidadeModel> findAll() {
        return cidadeRepository.findAll();
    }
    
}
