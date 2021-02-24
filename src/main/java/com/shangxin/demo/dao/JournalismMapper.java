package com.shangxin.demo.dao;


import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.Journalism;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface JournalismMapper extends Mapper<Journalism> {

    /**
     * 查询状态码为1的新闻，分页
     */
    @Select("select *from index_journalism where state=1")
    List<Journalism> findAllPage();

    /**
     * 下架新闻
     */
    @Update("update index_journalism set state=0 where id=#{id}")
    void soldout(Integer id);

    /**
     * 上架新闻
     */
    @Update("update index_journalism set state=1 where id=#{id}")
    void onthenews(Integer id);

    /**
     * 修改新闻
     */
    @Update("update index_journalism set name=#{name},result=#{result},time=#{time},img=#{img} where details_id=#{details_id}")
    void updatejournalism(Journalism journalism);

    /**
     * 查询新闻，分页
     */
    @Select("select *from index_journalism")
    List<Journalism> findAlljournalism();
}
