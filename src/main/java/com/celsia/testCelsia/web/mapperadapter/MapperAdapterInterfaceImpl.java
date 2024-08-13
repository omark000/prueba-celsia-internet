package com.celsia.testCelsia.web.mapperadapter;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class MapperAdapterInterfaceImpl<S,T> implements MapperAdapterInterfaceService<S,T> {

    private final ModelMapper modelMapper;
    public MapperAdapterInterfaceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public T mapperDtoToEntity(S source, Class<T> targetClass) {
        return modelMapper.map(source,targetClass);
    }

    @Override
    public List<T> mapperConvertListToDtoList(List<S> lstSource, Class<T> targetClass) {
        Type listDtoType = new TypeToken<List<T>>() {}.getType();
        return modelMapper.map(lstSource,listDtoType);
    }
}
