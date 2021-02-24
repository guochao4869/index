package com.shangxin.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangxin.demo.dao.Content2Mapper;
import com.shangxin.demo.dao.GoodsCarouselMapper;
import com.shangxin.demo.dao.GoodsparticularsMapper;
import com.shangxin.demo.pojo.Content2;
import com.shangxin.demo.pojo.IndexAboutus;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.Content2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class Content2Serviceimpl implements Content2Service {

    @Autowired
    private Content2Mapper content2Mapper;

    @Autowired
    private GoodsparticularsMapper goodsparticularsMapper;

    @Autowired
    private GoodsCarouselMapper goodsCarouselMapper;

    /**
     * 分页查询智慧阅读
     * @return
     */
    @Override
    public PageInfo findPage(int curPage, int  product_id) {

        List<Content2> list = content2Mapper.findByproductId(product_id);
        PageHelper.startPage(curPage,10);
        PageInfo pageInfo=new PageInfo(list);

        return pageInfo;
    }

    /**
     * 查询总页数
     * @param product_id
     * @return
     */
    @Override
    public Integer findCountPage(int product_id) {
        //总页数
        Integer allCount = content2Mapper.findCountPage(product_id);
        return allCount;
    }

    /**
     * 查询所有的产品数据
     * @Param currentpage   当前页
     * @return
     */
    @Override
    public PageInfo findgoods(int currentpage) {
        PageHelper.startPage(currentpage,10);

        List<Content2> findgoods = content2Mapper.findgoods();
        PageInfo pageInfo=new PageInfo(findgoods);

        return pageInfo;
    }

    /**
     * 产品批量下架
     * @param twoList
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void soldout(TwoList twoList) {
        //获取到传过来的id，遍历，并执行sql
        List<Integer> id = twoList.getId();
        try {
            for (Integer s : id) {
                content2Mapper.soldout(s);
            }

        }catch (Exception e){
            throw new RuntimeException("目录上架失败");
        }
        //获取到传过来的details_id，遍历，并执行sql
        List<Integer> details_id = twoList.getDetails_id();
        try {
            for (Integer s : details_id) {
                goodsparticularsMapper.soldout(s);

                try {
                    //这里也要去下架产品轮播图的数据
                    goodsCarouselMapper.soldout(s);
                }catch (Exception e){
                    System.out.println("轮播图中没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("目录上架失败");
        }
    }

    /**
     * 产品批量上架
     * @param twoList
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void goodsshelves(TwoList twoList) {
        List<Integer> id = twoList.getId();
        try {
            for (Integer s : id) {
                content2Mapper.goodsshelves(s);
            }

        }catch (Exception e){
            throw new RuntimeException("目录上架失败");
        }

        List<Integer> details_id = twoList.getDetails_id();
        try {
            for (Integer s : details_id) {
                goodsparticularsMapper.goodsshelves(s);
                try {
                    //这里也要去下架产品轮播图的数据
                    goodsCarouselMapper.putaway(s);
                }catch (Exception e){
                    //到就说明轮播图里面没有，不处理，正常执行
                    //System.out.println("轮播图中没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("目录上架失败");
        }
    }

    /**
     * 条件查询产品
     */
    @Override
    public PageInfo likeselect(Content2 content2,int currentpage) {
        Example example = createExample(content2);
        PageHelper.startPage(currentpage,10);
        List<Content2> list = content2Mapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    /**
     * 批量删除产品
     * @param twoList
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void deletegoods(TwoList twoList) {
        //获取目录id
        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                //循环遍历集合批量删除产品目录
                content2Mapper.deleteByPrimaryKey(integer);
            }
        }catch (Exception e){
            throw new RuntimeException("删除产品目录失败");
        }

        //获取详情id
        List<Integer> details_id = twoList.getDetails_id();

        try {
            for (Integer integer : details_id) {
                //循环遍历集合批量删除产品详情
                goodsparticularsMapper.deleteByPrimaryKey(integer);
                try {
                    //这里也要去删除产品轮播图的数据
                    goodsCarouselMapper.batchdelete(integer);
                }catch (Exception e){
                    //到就说明轮播图里面没有，不处理，正常执行
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("删除产品详情失败");
        }
    }

    /**
     * 构建查询对象
     * @param content2
     * @return
     */
    public Example createExample(Content2 content2){
        Example example=new Example(Content2.class);
        Example.Criteria criteria = example.createCriteria();
        if(content2!=null){
            // 主键
            if(!StringUtils.isEmpty(content2.getId())){
                criteria.andEqualTo("id",content2.getId());
            }
            //名字
            if(!StringUtils.isEmpty(content2.getName())){
                criteria.andLike("name","%"+content2.getName()+"%");
            }
            // 状态
            if(!StringUtils.isEmpty(content2.getState())){
                criteria.andEqualTo("state",content2.getState());
            }
            // 详情
            if(!StringUtils.isEmpty(content2.getCentent())){
                criteria.andLike("centent",content2.getCentent());
            }
            // 分类id
            if(!StringUtils.isEmpty(content2.getProduct_id())){
                criteria.andEqualTo("product_id",content2.getProduct_id());
            }
        }
        return example;
    }

}
