package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.Slideshow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SlideshowMapper extends Mapper<Slideshow> {

    /**
     * 插入轮播图的数据
     * @param slideshow
     */
    @Insert("insert into index_slideshow(img,name,classify,state,details_id,fatherid) values(#{img},#{name},#{classify},#{state},#{details_id},#{fatherid})")
    void insertslideshow(Slideshow slideshow);

    /**
     * 批量下架（因为新闻，活动，专利，荣誉下架了这个也要跟着变）
     */
    @Update("update index_slideshow set state=0 where fatherid=#{fatherid} and classify=#{classify}")
    void soldout(int fatherid,String classify);

    /**
     * 批量上架（因为新闻，活动，专利，荣誉上架了这个也要跟着变）
     */
    @Update("update index_slideshow set state=1 where fatherid=#{fatherid} and classify=#{classify}")
    void putaway(int fatherid,String classify);

    /**
     * 批量删除轮播图
     * @param fatherid
     * @param classify
     */
    @Delete("delete from index_slideshow where fatherid=#{fatherid} and classify=#{classify}")
    void batchdelete(int fatherid,String classify);

    /**
     * 修改轮播图图片
     * @param id
     * @param img
     */
    @Update("update index_slideshow set img=#{img},name=#{name} where id=#{id}")
    void updateslideshow(Integer id,String img,String name);

    @Select("select *from index_slideshow where state=1")
    List<Slideshow> findslideshow();

    /**
     * 根据父类的id去查询轮播图
     * @param fatherid
     * @return
     */
    @Select("select *from index_slideshow where fatherid=#{fatherid}")
    Slideshow selectByfatherId(String fatherid);
}
