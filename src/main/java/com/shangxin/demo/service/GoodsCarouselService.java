package com.shangxin.demo.service;


import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.GoodsCarousel;
import com.shangxin.demo.pojo.TwoList;

import java.util.List;

/**
 * 产品轮播图接口
 */
public interface GoodsCarouselService {


    /**
     * 查询所有状态码1且根据轮播图的id跳转到产品详情页面
     * @param goodsdetailsid
     * @return
     */
    List<GoodsCarousel> findGoodsCarouselBygoodsdetailsid(int goodsdetailsid);

    /**
     * 查询所有状态码1且根据轮播图
     */
    List<GoodsCarousel> findGoodsCarouselAll();

    /**
     * 后台查询所有的产品轮播图
     * @return
     */
    PageInfo findAll(Integer currentpage);


    /**
     * 修改产品轮播图中的图片
     * @param id
     */
    void updateslideshow(Integer id,String img,String name);

    /**
     * 批量删除产品轮播图图片
     * @param twoList
     */
    void deleteslideshow(TwoList twoList);

    /**
     * 新增产品轮播图
     * @param goodsCarousel
     */
    void insertgoodscarousel(GoodsCarousel goodsCarousel);
}
