package com.shangxin.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangxin.demo.dao.JournalismContentMapper;
import com.shangxin.demo.dao.JournalismMapper;
import com.shangxin.demo.pojo.JournalismResult;
import com.shangxin.demo.dao.JournalismResultMapper;
import com.shangxin.demo.pojo.Journalism;
import com.shangxin.demo.pojo.JournalismContent;
import com.shangxin.demo.service.JournalismContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JournalismContentServiceimpl implements JournalismContentService {

    @Autowired
    private JournalismContentMapper journalismContentMapper;

    @Autowired
    private JournalismMapper journalismMapper;

    @Autowired
    private JournalismResultMapper journalismResultMapper;

    /**
     * 根据传过来的id区查询新闻的详情数据
     * @param JournalismId
     * @return
     */
    @Override
    public JournalismContent findJournalismContent(int JournalismId) {
        JournalismContent journalismContent = journalismContentMapper.selectByPrimaryKey(JournalismId);
        return journalismContent;
    }

    /**
     * 新增新闻
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void insertjournalismcontent(JournalismContent journalismContent) {

        try {
            //新增了新闻详情
            journalismContentMapper.insert(journalismContent);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增新闻详细出错");
        }


        //获取新闻目录需要的字段信息
        String name = journalismContent.getName();
        String content = journalismContent.getContent();
        String img = journalismContent.getImg();
        String time = journalismContent.getTime();
        Integer id = journalismContent.getId();

        Journalism journalism = new Journalism();
        journalism.setDetails_id(id);
        journalism.setImg(img);
        journalism.setResult(content);
        journalism.setName(name);
        journalism.setTime(time);

        try {
            //新增了新闻详情
            journalismMapper.insert(journalism);
        }catch (Exception e){
            throw new RuntimeException("新增新闻目录出错");
        }

    }

    /**
     * 修改新闻数据
     * @param journalismContent
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void updatejournalismcontent(JournalismContent journalismContent) {

        //获取新闻目录需要的字段信息
        String name = journalismContent.getName();
        String content = journalismContent.getContent();
        String img = journalismContent.getImg();
        String time = journalismContent.getTime();
        Integer id = journalismContent.getId();

        Journalism journalism = new Journalism();
        journalism.setDetails_id(id);
        journalism.setImg(img);
        journalism.setResult(content);
        journalism.setName(name);
        journalism.setTime(time);

        //修改了新闻详情
        try {
            journalismContentMapper.updateByPrimaryKey(journalismContent);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新闻详情修改失败");
        }

        //修改了新闻详情
        try {
            journalismMapper.updatejournalism(journalism);
        }catch (Exception e){
            throw new RuntimeException("新闻目录修改失败");
        }

    }

    /**
     * 后台展示新闻列表
     * @return
     */
    @Override
    public PageInfo findJournalismlist(Integer currentpage) {
        PageHelper.startPage(currentpage,10);
        List<JournalismResult> journalismlist = journalismResultMapper.findJournalismlist();
        PageInfo pageInfo=new PageInfo(journalismlist);
        return pageInfo;
    }


}
