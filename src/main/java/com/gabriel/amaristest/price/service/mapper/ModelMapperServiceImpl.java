package com.gabriel.amaristest.price.service.mapper;

import com.gabriel.amaristest.price.interfaces.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ModelMapperServiceImpl")
public class ModelMapperServiceImpl implements ModelMapperService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public <D, E> D convert(E element, Class<D> destinationType) {
        return modelMapper.map(element, destinationType);
    }
}
