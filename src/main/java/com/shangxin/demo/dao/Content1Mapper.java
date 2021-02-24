package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.Content1;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Content1Mapper extends Mapper<Content1> {

    @Select("select *from index_goodscontent1 where classify=#{classify}")
    List<Content1> findAllIndexWisdomRead1(int classify);
}
