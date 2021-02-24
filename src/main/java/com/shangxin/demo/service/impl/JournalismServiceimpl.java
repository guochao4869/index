package com.shangxin.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangxin.demo.dao.JournalismContentMapper;
import com.shangxin.demo.dao.JournalismMapper;
import com.shangxin.demo.dao.JournalismResultMapper;
import com.shangxin.demo.dao.SlideshowMapper;
import com.shangxin.demo.pojo.*;
import com.shangxin.demo.service.JournalismService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class JournalismServiceimpl implements JournalismService {

    @Autowired
    private JournalismMapper journalismMapper;

    @Autowired
    private JournalismContentMapper journalismContentMapper;

    @Autowired
    private SlideshowMapper slideshowMapper;

    @Autowired
    private JournalismResultMapper journalismResultMapper;

    /**
     * 分页查询所有状态码为1的新闻数据
     * @return
     */
    @Override
    public PageInfo findAllPage(Integer page) {
        PageHelper.startPage(page, 10,"time desc");
        List<Journalism> list = journalismMapper.findAllPage();

        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    /**
     * 批量下架新闻
     * @param twoList
     */
    @Transactional(rollbackFor=RuntimeException.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void soldout(TwoList twoList) {
        List<Integer> id = twoList.getId();
        try {
            for (Integer s : id) {
                journalismMapper.soldout(s);
                try {
                    slideshowMapper.soldout(s,"新闻");
                }catch (Exception e){
                    System.out.println("轮播图里面没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("新闻下架失败");
        }
    }

    /**
     * 批量上架新闻
     * @param twoList
     */
    @Override
    public void onthenews(TwoList twoList) {
        List<Integer> id = twoList.getId();
        try {
            for (Integer s : id) {
                journalismMapper.onthenews(s);
                try {
                    slideshowMapper.putaway(s,"新闻");
                }catch (Exception e){
                    System.out.println("轮播图里面没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("新闻上架失败");
        }
    }

    /**
     * 批量删除新闻
     * @param
     */
    @Transactional(rollbackFor=RuntimeException.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void deletejournalism(TwoList twoList) {
        //获取目录id
        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                //循环遍历集合批量删除新闻目录
                journalismMapper.deleteByPrimaryKey(integer);

                try {
                    slideshowMapper.batchdelete(integer,"新闻");
                }catch (Exception e){
                    System.out.println("轮播图里面没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("删除新闻目录失败");
        }

        //获取详情id
        List<Integer> details_id = twoList.getDetails_id();

        try {
            for (Integer integer : details_id) {
                //循环遍历集合批量删除新闻详情
                journalismContentMapper.deleteByPrimaryKey(integer);
            }
        }catch (Exception e){
            throw new RuntimeException("删除新闻详情失败");
        }
    }

    /**
     * 新闻条件查询
     * @param journalismResult
     * @return
     */
    @Override
    public PageInfo conditionquery(JournalismResult journalismResult,int currentpage) {
        // Example example=createExample(journalismResult);
        PageHelper.startPage(currentpage,10);
        //List<JournalismResult> journalismlist = journalismResultMapper.selectByExample(example);
        List<JournalismResult> conditionquery = journalismResultMapper.conditionquery(journalismResult);
        PageInfo pageInfo=new PageInfo(conditionquery);
        return pageInfo;
    }

    /**
     * 构建查询对象
     * @param journalismResult
     * @return
     */
    public Example createExample(JournalismResult journalismResult){
        Example example=new Example(Content2.class);
        Example.Criteria criteria = example.createCriteria();
        if(journalismResult!=null){
            // 主键
            if(!StringUtils.isEmpty(journalismResult.getId())){
                criteria.andEqualTo("id",journalismResult.getId());
            }
            //名字
            if(!StringUtils.isEmpty(journalismResult.getName())){
                criteria.andLike("name","%"+journalismResult.getName()+"%");
            }
            // 状态
            if(!StringUtils.isEmpty(journalismResult.getState())){
                criteria.andEqualTo("state",journalismResult.getState());
            }
            // 来源
            if(!StringUtils.isEmpty(journalismResult.getName())){
                criteria.andLike("source","%"+journalismResult.getSource()+"%");
            }
            // 作者
            if(!StringUtils.isEmpty(journalismResult.getWriter())){
                criteria.andLike("writer","%"+journalismResult.getWriter()+"%");
            }
            // 时间  如果只有第一个，就到当前时间
            if(!StringUtils.isEmpty(journalismResult.getTime())){
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                String formatdate = simpleDateFormat.format(date);
                criteria.orBetween("time",journalismResult.getTime(),formatdate);
            }
            // 时间区间   2个时间段都存在
            if(!StringUtils.isEmpty(journalismResult.getTime()) && !StringUtils.isEmpty(journalismResult.getTime2())){
                criteria.orBetween("time",journalismResult.getTime(),journalismResult.getTime2());
            }

            // 时间区间   第一个时间存在，第二个不存在
            if(!StringUtils.isEmpty(journalismResult.getTime2())){
                String oldtime="1949-10-01";
                criteria.orBetween("time",oldtime,journalismResult.getTime2());
            }
        }
        return example;
    }
}
