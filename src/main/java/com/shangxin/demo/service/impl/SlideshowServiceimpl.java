package com.shangxin.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.shangxin.demo.dao.SlideshowMapper;
import com.shangxin.demo.pojo.Slideshow;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SlideshowServiceimpl implements SlideshowService {

    @Autowired
    private SlideshowMapper slideshowMapper;

    /**
     * 插入一条轮播图数据
     * @param slideshow
     */
    @Override
    public void insertslideshow(Slideshow slideshow) {

        //先要去查询一下看下是否有没有
        Slideshow byfatherId = slideshowMapper.selectByfatherId(slideshow.getFatherid());
        if (byfatherId!=null){
            throw new RuntimeException("已经有该轮播图，加入失败");
        }
        //获取分类，进行字符串替换
        String classify = slideshow.getClassify();
        if (classify.equals("1")){
            classify="荣誉";
        }
        if (classify.equals("2")){
            classify="专利";
        }
        if (classify.equals("3")){
            classify="活动";
        }
        slideshow.setClassify(classify);
        slideshowMapper.insertslideshow(slideshow);
    }

    /**
     * 查询所有进轮播图的信息
     * @return
     */
    @Override
    public PageInfo selectslideshow(int currentpage) {
        List<Slideshow> slideshows = slideshowMapper.selectAll();
        //使用分页插件,默认每页显示十条
        PageHelper.startPage(currentpage,10);
        PageInfo pageInfo=new PageInfo(slideshows);
        //返回分页的数据
        return pageInfo;
    }

    /**
     * 批量删除轮播图
     * @param twoList
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteslideshow(TwoList twoList) {
        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                slideshowMapper.deleteByPrimaryKey(integer);
            }
        }catch (Exception e){
            throw new RuntimeException("删除轮播图失败");
        }

    }

    /**
     * 修改轮播图图片
     * @param id
     * @param img
     */
    @Override
    public void updateslideshow(Integer id, String img,String name) {
        try {
            slideshowMapper.updateslideshow(id,img,name);
        }catch (Exception e){
            throw new RuntimeException("修改轮播图图片失败");
        }
    }
}
