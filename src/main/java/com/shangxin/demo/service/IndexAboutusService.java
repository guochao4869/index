package com.shangxin.demo.service;



import com.shangxin.demo.pojo.IndexAboutus;
import com.shangxin.demo.pojo.JournalismResult;
import com.shangxin.demo.pojo.Slideshow;

import java.util.List;

/****
 * @Author:itheima
 * @Description:IndexAboutus业务层接口
 *****/
public interface IndexAboutusService {

    /***
     * 查询关羽我们上架状态的轮播图
     * @return
     */
    List<Slideshow> findAll();

    /**
     * 查询所有的关于我们轮播图
     * @return
     */
    public List<IndexAboutus> selectAll();
}
