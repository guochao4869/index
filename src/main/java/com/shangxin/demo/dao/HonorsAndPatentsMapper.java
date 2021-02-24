package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.HonorsAndPatents;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface HonorsAndPatentsMapper extends Mapper<HonorsAndPatents> {

    /**
     * 查询上线的集团荣誉
     */
    @Select("select *from index_honorsandpatentsandactivity where state=1 and classify=1")
    List<HonorsAndPatents> findHonorsAll();

    /**
     * 查询上线的专利
     */
    @Select("select *from index_honorsandpatentsandactivity where state=1 and classify=2")
    List<HonorsAndPatents> findPatentsAll();

    /**
     * 查询上线的活动
     */
    @Select("select *from index_honorsandpatentsandactivity where state=1 and classify=3")
    List<HonorsAndPatents> findactivityAll();



    /**
     * 查询所有的集团荣誉
     */
    @Select("select *from index_honorsandpatentsandactivity where classify=1")
    List<HonorsAndPatents> findHonors();

    /**
     * 查询所有的专利
     */
    @Select("select *from index_honorsandpatentsandactivity where  classify=2")
    List<HonorsAndPatents> findPatents();

    /**
     * 查询所有的活动
     */
    @Select("select *from index_honorsandpatentsandactivity where  classify=3")
    List<HonorsAndPatents> findactivity();

    /**
     * 修改活动目录信息
     * @param honorsAndPatents
     */
    @Update("update index_honorsandpatentsandactivity set img=#{img},name=#{name},content=#{content} where details_id=#{details_id}")
    void updateactivity(HonorsAndPatents honorsAndPatents);

    /**
     * 批量上架专利或者荣誉
     * @param id
     */
    @Update("update index_honorsandpatentsandactivity set state=1 where id=#{id}")
    void putaway(Integer id);

    /**
     * 批量下架专利或者荣誉
     * @param id
     */
    @Update("update index_honorsandpatentsandactivity set state=0 where id=#{id}")
    void soldout(Integer id);

    @Select("select *from ")
    HonorsAndPatents selectByDetailsid(Integer details_id);
}
