package com.shangxin.demo.service;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.Slideshow;
import com.shangxin.demo.pojo.TwoList;

public interface SlideshowService {

    /**
     * 插入一条轮播图数据
     * @param slideshow
     */
    void insertslideshow(Slideshow slideshow);

    /**
     * 查询所有进轮播图的信息
     * @return
     */
    PageInfo selectslideshow(int currentpage);

    /**
     * 删除轮播图
     * @param twoList
     */
    void deleteslideshow(TwoList twoList);

    /**
     * 修改轮播图图片
     * @param id
     * @param img
     */
    void updateslideshow(Integer id,String img,String name);
}
