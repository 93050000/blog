package com.zhao.service.impl;

import com.zhao.mapper.CategoriyMapper;
import com.zhao.pojo.Categoriy;
import com.zhao.service.CategoriyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriyServiceImpl implements CategoriyService{

    @Autowired
    CategoriyMapper categoriyMapper;
    @Override
    public List<Categoriy> queryCategoriy() {
        return categoriyMapper.queryCategoriy();
    }
}
