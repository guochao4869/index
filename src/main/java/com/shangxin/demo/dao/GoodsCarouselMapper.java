package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.GoodsCarousel;
import com.shangxin.demo.pojo.Slideshow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface GoodsCarouselMapper extends Mapper<GoodsCarousel> {

    /**
     * 查询所有状态码1且根据轮播图的id跳转到产品详情页面
     * @param goodsdetailsid
     * @return
     */
    @Select("select p1.*from  index_goods_carousel p1 left JOIN index_goods_details p2  on p1.details_id=p2.id  where p2.state=1 and p1.id=#{goodsdetailsid}")
    List<GoodsCarousel> findGoodsCarouselBygoodsdetailsid(int goodsdetailsid);

    /**
     * 查询所有状态码1且根据轮播图
     */
    @Select("select p1.*from  index_goods_carousel p1 left JOIN index_goods_details p2  on p1.details_id=p2.id  where p2.state=1")
    List<GoodsCarousel> findGoodsCarouselAll();

    /**
     * 批量下架（产品下架了这个也要跟着变）
     */
    @Update("update  index_goods_carousel set state=0 where goodsId=#{goodsId}")
    void soldout(int goodsId);

    /**
     * 批量上架（产品上架了这个也要跟着变）
     */
    @Update("update index_goods_carousel set state=1 where goodsId=#{goodsId}")
    void putaway(int goodsId);

    /**
     * 批量删除轮播图（产品删除了这个也要跟着变）
     */
    @Delete("delete from index_goods_carousel where details_id=#{details_id} ")
    void batchdelete(int goodsId);

    /**
     * 修改轮播图图片
     */
    @Update("update index_goods_carousel set img=#{img},name=#{name} where id=#{id}")
    void updateslideshow(int id,String img,String name);

    /**
     * 插入产品轮播图的数据
     * @param goodsCarousel
     */
    @Insert("insert into index_goods_carousel(img,name,classify,state,goodsId,details_id) values(#{img},#{name},#{classify},#{state},#{goodsId},#{details_id})")
    void insertgoodscarousel(GoodsCarousel goodsCarousel);

    @Select("select *from index_goods_carousel where goodsId=#{goodsId}")
    GoodsCarousel selectBygoodsid(int goodsId);


}
