package com.ttdys.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

@Slf4j
public class BaseService<T, M extends Mapper<T>> {

    @Autowired
    protected M mapper;


}
