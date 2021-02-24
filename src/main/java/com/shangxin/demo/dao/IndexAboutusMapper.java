package com.shangxin.demo.dao;


import com.shangxin.demo.pojo.IndexAboutus;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****

 * @Description:IndexAboutus的Dao
 *****/

@org.apache.ibatis.annotations.Mapper
public interface IndexAboutusMapper extends Mapper<IndexAboutus> {

    @Select("select *from index_aboutus where state=1")
    List<IndexAboutus> findAll();
}
