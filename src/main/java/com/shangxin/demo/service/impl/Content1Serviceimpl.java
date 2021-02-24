package com.shangxin.demo.service.impl;

import com.shangxin.demo.dao.Content1Mapper;
import com.shangxin.demo.pojo.Content1;
import com.shangxin.demo.service.Content1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Content1Serviceimpl implements Content1Service {

    @Autowired
    private Content1Mapper indexWisdomRead1Mapper;


    /**
     * 点击查询classify的数据
     * @param classify
     * @return
     */
    @Override
    public List<Content1> findAllIndexWisdomRead1(Integer classify) {
        List<Content1> list = indexWisdomRead1Mapper.findAllIndexWisdomRead1(classify);
        return list;
    }
}
