package com.rdr.sglserverjava.shared;

import com.rdr.sglserverjava.security.TenantContext;

abstract public class BaseService<T> {

    BaseRepository baseRepository;

    public BaseService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T findById(Long id) {
        var item = baseRepository.findByTenantIdAndId(TenantContext.getTenantId(), id);
        if (!item.isEmpty())
            return (T) item.get();
        else
            return null;
    }    
    
    
}
