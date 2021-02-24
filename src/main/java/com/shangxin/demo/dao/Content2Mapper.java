package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.Content2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Content2Mapper extends Mapper<Content2> {

    /**
     * 查询商品列表，分页查询
     * @param curPage
     * @param product_id
     * @return
     */
    @Select("select *from index_goodscontent2  where product_id=#{product_id} and state=1 ")
    List<Content2> findByproductId( @Param("product_id") int  product_id);

    /**
     * 根据分类来查询商品详情
     * @param product_id
     * @return
     */
    @Select("select COUNT(id) count from  index_goodscontent2 where product_id=#{product_id} ")
    Integer findCountPage(int product_id);

    /**
     * 后台查询商品详情
     * @return
     */
    @Select("select id,centent,state,product_id,name,details_id from index_goodscontent2 ")
    List<Content2> findgoods();

    /**
     * 新增商品
     */
    @Insert("insert into index_goodscontent2(img,centent,product_id,name,details_id) \n" +
            "VALUES(#{img},#{centent},#{product_id},#{name},#{details_id})")
    void insertgoods(Content2 content2);

    /**
     * 修改商品数据
     */
    @Update("update index_goodscontent2 set img=#{img}, centent=#{centent},product_id=#{product_id},name=#{name} " +
            "where details_id=#{details_id}")
    void updategoods(Content2 content2);

    /**
     * 下架商品
     * @param id
     */
    @Update("update index_goodscontent2 set state=0 where id=#{id}")
    void soldout(Integer id);

    /**
     * 上架商品
     * @param id
     */
    @Update("update index_goodscontent2 set state=1 where id=#{id}")
    void goodsshelves(Integer id);

    /**
     * 条件查询产品
     */
   // List<Content2> likeselect(Map<String,String> map);

}
