package com.shangxin.demo.service;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.Journalism;
import com.shangxin.demo.pojo.JournalismResult;
import com.shangxin.demo.pojo.TwoList;

import java.util.List;

public interface JournalismService {

    /**
     * 分页查询所有状态码为1的所有新闻
     * page 当前第几页
     * @return
     */
    PageInfo findAllPage(Integer page);

    /**
     * 下架新闻
     */
    void soldout(TwoList twoList);

    /**
     * 上架新闻
     */
    void onthenews(TwoList twoList);

    /**
     * 批量删除新闻
     */
    void deletejournalism(TwoList twoList);

    /**
     * 条件查询
     * @param journalismResult
     * @return
     */
    PageInfo conditionquery(JournalismResult journalismResult,int currentpage);

}
