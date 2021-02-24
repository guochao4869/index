package com.shangxin.demo.dao;


import com.shangxin.demo.pojo.Goodsparticulars;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface GoodsparticularsMapper extends Mapper<Goodsparticulars> {

    @Select("select *from index_goods_details where id =#{id} and state=1")
    Goodsparticulars findById(int id);

    /**
     * 新增商品详情
     * @param goodsparticulars
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into index_goods_details(name,img,smallname,length,result,video,videodescribe,goodsshowname,goodsshowimg,showimgdescribe,classify) \n" +
            "VALUES(#{name},#{img},#{smallname},#{length},#{result},#{video},#{videodescribe},#{goodsshowname},#{goodsshowimg},#{showimgdescribe},#{classify})")
    void insertgoodssparticulars(Goodsparticulars goodsparticulars);

    /**
     * 修改商品详情
     * @param goodsparticulars
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Update("update index_goods_details set name=#{name},img=#{img},smallname=#{smallname},length=#{length},result=#{result},video=#{video},videodescribe=#{videodescribe},\n" +
            "goodsshowname=#{goodsshowname},goodsshowimg=#{goodsshowimg},showimgdescribe=#{showimgdescribe},classify=#{classify} where id=#{id}")
    void updategoodssparticulars(Goodsparticulars goodsparticulars);

    /**
     * 修改数据库图片地址
     * @param imgurl
     * @param id
     */
    @Update("update index_goods_details set img=#{imgurl} where id=#{id}")
    void updateimg(@Param("imgurl") String imgurl,@Param("id") int id);

    /**
     * 下架商品
     * @param id
     */
    @Update("update index_goods_details set state=0 where id=#{id}")
    void soldout(Integer id);

    /**
     * 上架商品
     * @param id
     */
    @Update("update index_goods_details set state=1 where id=#{id}")
    void goodsshelves(Integer id);

}
