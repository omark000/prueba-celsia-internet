package com.celsia.testCelsia.web.mapperadapter;

import java.util.List;

public interface MapperAdapterInterfaceService<S,T>{
    T mapperDtoToEntity(S source, Class<T> targetClass);
    List<T> mapperConvertListToDtoList(List<S> lstSource,Class<T> targetClass );
}
