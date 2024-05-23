package com.rdr.sglserverjava.cor;

import org.springframework.stereotype.Service;

import com.rdr.sglserverjava.shared.BaseService;

@Service
public class CorService extends BaseService<Cor>{

    public CorService(CorRepository corRepository) {
        super(corRepository);
    }
    
}
