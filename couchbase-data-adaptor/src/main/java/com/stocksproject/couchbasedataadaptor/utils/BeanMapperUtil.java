package com.stocksproject.couchbasedataadaptor.utils;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BeanMapperUtil {

    @Autowired
    private DozerBeanMapper mapper;


    public <T> T map(Object from, Class<T> toClass) {
//        beanMapper = new DozerBeanMapper();
        return this.mapper.map(from, toClass);
    }

    public <F,T> List<T> mapList(List<F> fromList, final Class<T> toClass) {
//        beanMapper = new DozerBeanMapper();
        return fromList.stream().map(from -> this.mapper.map(from, toClass)).collect(Collectors.toList());
    }

}
