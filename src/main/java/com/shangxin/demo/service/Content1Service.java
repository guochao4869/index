package com.shangxin.demo.service;

import com.shangxin.demo.pojo.Content1;

import javax.jws.WebService;
import java.util.List;

/**
 * 查分类详情点服务层
 */
public interface Content1Service {

    /**
     * 查询内容1
     * @return
     */
    List<Content1> findAllIndexWisdomRead1(Integer classify);

}
