package com.shangxin.demo.service;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.pojo.JournalismContent;

public interface JournalismContentService {

    JournalismContent findJournalismContent(int JournalismId);

    /**
     * 新增新闻
     * @param journalismContent
     */
    void insertjournalismcontent(JournalismContent journalismContent);

    /**
     * 修改新闻
     * @param journalismContent
     */
    void updatejournalismcontent(JournalismContent journalismContent);

    /**
     * 后台展示新闻列表
     * @return
     */
    PageInfo findJournalismlist(Integer currentpage);


}
