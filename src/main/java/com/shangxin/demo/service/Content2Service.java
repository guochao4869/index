package com.shangxin.demo.service;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.Content2;
import com.shangxin.demo.pojo.TwoList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Content2Service {

    /**
     * 分页查询数据2
     * @param curPage
     * @param product_id
     * @return
     */
    PageInfo findPage(int curPage, int  product_id);

    /**
     * 查询有多少条数据
     */
    Integer findCountPage(int product_id);

    /**
     * 查询所有的产品数据
     */
    PageInfo findgoods(int currentpage);

    /**
     * 产婆下架
     * @param twoList
     */
    void soldout(TwoList twoList);

    /**
     * 产品上架
     * @param twoList
     */
    void goodsshelves(TwoList twoList);

    /**
     * 条件查询产品
     */
    PageInfo likeselect(Content2 content2,int currentpage);

    /**
     * 批量删除产品
     * @param twoList
     */
    void deletegoods(TwoList twoList);


}
