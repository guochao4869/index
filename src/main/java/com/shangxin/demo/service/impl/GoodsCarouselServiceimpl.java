package com.shangxin.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangxin.demo.dao.Content2Mapper;
import com.shangxin.demo.dao.GoodsCarouselMapper;
import com.shangxin.demo.pojo.Content2;
import com.shangxin.demo.pojo.GoodsCarousel;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.GoodsCarouselService;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsCarouselServiceimpl implements GoodsCarouselService {

    @Autowired
    private GoodsCarouselMapper goodsCarouselMapper;

    @Autowired
    private Content2Mapper content2Mapper;

    /**
     * 查询所有状态码1且根据轮播图的id跳转到产品详情页面
     * @param goodsdetailsid
     * @return
     */
    @Override
    public List<GoodsCarousel> findGoodsCarouselBygoodsdetailsid(int goodsdetailsid) {
        List<GoodsCarousel> list = goodsCarouselMapper.findGoodsCarouselBygoodsdetailsid(goodsdetailsid);
        return list;
    }

    /**
     * 前台页面查询所有状态码为1的轮播图
     * @return
     */
    @Override
    public List<GoodsCarousel> findGoodsCarouselAll() {
        List<GoodsCarousel> goodsCarouselAll = goodsCarouselMapper.findGoodsCarouselAll();
        return goodsCarouselAll;
    }

    /**
     * 后台查询所有的产品轮播图
     * @return
     */
    @Override
    public PageInfo findAll(Integer currentpage) {
        List<GoodsCarousel> goodsCarousels = goodsCarouselMapper.selectAll();
        PageHelper.startPage(currentpage,10);
        PageInfo pageInfo=new PageInfo(goodsCarousels);
        return pageInfo;
    }

    /**
     * 修改产品轮播图中的图片
     * @param id
     */
    @Override
    public void updateslideshow(Integer id,String img,String name) {
        goodsCarouselMapper.updateslideshow(id,img,name);
    }

    /**
     * 批量删除产品轮播图图片
     * @param twoList
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteslideshow(TwoList twoList) {

        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                goodsCarouselMapper.deleteByPrimaryKey(integer);
            }
        }catch (Exception e){
            throw new RuntimeException("批量删除产品轮播图失败");
        }
    }

    /**
     * 新增产品轮播图
     * @param goodsCarousel
     */
    @Override
    public void insertgoodscarousel(GoodsCarousel goodsCarousel) {

        //去查询，轮播图里面是否已经有该轮播图，如果有就拒绝，不让添加
        if (goodsCarouselMapper.selectBygoodsid(goodsCarousel.getGoodsId())!=null){
                throw new RuntimeException("已存在轮播图，新增失败");
        }

        //再查一次，获取图片信息
        Integer id = goodsCarousel.getGoodsId();
        Content2 content2 = content2Mapper.selectByPrimaryKey(id);
        String img = content2.getImg();
        goodsCarousel.setImg(img);
        try {
            goodsCarouselMapper.insertgoodscarousel(goodsCarousel);
        }catch (Exception e){
            throw new RuntimeException("新增产品轮播图时出错");
        }

    }
}
