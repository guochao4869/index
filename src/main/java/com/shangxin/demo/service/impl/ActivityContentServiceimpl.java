package com.shangxin.demo.service.impl;

import com.shangxin.demo.dao.ActivityContentMapper;
import com.shangxin.demo.dao.HonorsAndPatentsMapper;
import com.shangxin.demo.dao.SlideshowMapper;
import com.shangxin.demo.pojo.ActivityContent;
import com.shangxin.demo.pojo.HonorsAndPatents;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.ActivityContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActivityContentServiceimpl implements ActivityContentService {

    @Autowired
    private ActivityContentMapper activityContentMapper;

    @Autowired
    private HonorsAndPatentsMapper honorsAndPatentsMapper;

    @Autowired
    private SlideshowMapper slideshowMapper;

    /**
     * 根据活动id查询新闻点详情
     * @param detailsid
     * @return
     */
    @Override
    public ActivityContent findActivityContent(int detailsid) {
        ActivityContent activityContent = activityContentMapper.findActivityContent(detailsid);

        return activityContent;
    }

    /**
     * 查看活动的详情所有的的
     * @param detailsid
     * @return
     */
    @Override
    public ActivityContent findActivityContentAll(int detailsid) {
        return activityContentMapper.findActivityContentAll(detailsid);
    }

    /**
     * 新增活动
     * @param activityContent
     */
    @Transactional(rollbackFor=Exception.class)   //开启事务，如果出现运行时异常就回滚
    @Override
    public void insertActivityContent(ActivityContent activityContent) {
        //新增活动详情数据
        try {
            activityContentMapper.insert(activityContent);
        }catch (Exception e){
            throw new RuntimeException("新增活动详情失败");
        }

        //把传过来的值获取出来
        String id = activityContent.getId();
        String img = activityContent.getImg();
        String title = activityContent.getTitle();
        String content = activityContent.getContent();
        String starttime = activityContent.getStarttime();

        HonorsAndPatents honorsAndPatents=new HonorsAndPatents();
        honorsAndPatents.setName(title);
        honorsAndPatents.setDetails_id(id);
        honorsAndPatents.setContent(content);
        honorsAndPatents.setImg(img);
        honorsAndPatents.setClassify("3");
        honorsAndPatents.setTime(starttime);
        honorsAndPatents.setState("0");
        //新增活动目录
        try {
            honorsAndPatentsMapper.insert(honorsAndPatents);
        }catch (Exception e){
            throw new RuntimeException("新增活动目录失败");
        }

    }

    /**
     * 修改活动数据
     * @param activityContent
     */
    @Override
    public void updateActivityContent(ActivityContent activityContent) {
        //修改活动详情数据
        try {
            activityContentMapper.updateByPrimaryKey(activityContent);
        }catch (Exception e){
            throw new RuntimeException("修改活动详情失败");
        }
       // honorsAndPatentsMapper.selectByPrimaryKey()

        //把传过来的值获取出来
        String id = activityContent.getId();
        String img = activityContent.getImg();
        String title = activityContent.getTitle();
        String content = activityContent.getContent();
        String starttime = activityContent.getStarttime();

        HonorsAndPatents honorsAndPatents=new HonorsAndPatents();
        honorsAndPatents.setName(title);
        honorsAndPatents.setDetails_id(id);
        honorsAndPatents.setContent(content);
        honorsAndPatents.setImg(img);
        honorsAndPatents.setClassify("3");
        honorsAndPatents.setTime(starttime);

        //修改活动目录
        try {
            honorsAndPatentsMapper.updateactivity(honorsAndPatents);
        }catch (Exception e){
            throw new RuntimeException("修改活动目录失败");
        }
    }

    /**
     * 批量下架活动
     * @param twoList
     */
    @Override
    public void soldout(TwoList twoList) {
        List<Integer> id = twoList.getId();
        try {
            for (Integer s : id) {
                activityContentMapper.soldout(s);
                try {
                    HonorsAndPatents list = honorsAndPatentsMapper.selectByPrimaryKey(s);
                    String classify = list.getClassify();
                    if (classify.equals("1")){
                        classify="荣誉";
                    }
                    if (classify.equals("2")){
                        classify="专利";
                    }
                    if (classify.equals("3")){
                        classify="活动";
                    }
                    slideshowMapper.soldout(s,classify);
                }catch (Exception e){
                    //到就说明轮播图里面没有，不处理，正常执行
                }
            }
        }catch (Exception e){
            throw new RuntimeException("活动下架失败");
        }

    }

    /**
     * 批量下架活动
     * @param twoList
     */
    @Override
    public void putaway(TwoList twoList) {
        List<Integer> id = twoList.getId();
        try {
            for (Integer s : id) {
                activityContentMapper.putaway(s);
                try {
                    HonorsAndPatents list = honorsAndPatentsMapper.selectByPrimaryKey(s);
                    String classify = list.getClassify();
                    if (classify.equals("1")){
                        classify="荣誉";
                    }
                    if (classify.equals("2")){
                        classify="专利";
                    }
                    if (classify.equals("3")){
                        classify="活动";
                    }
                    slideshowMapper.putaway(s,classify);
                }catch (Exception e){
                    //到就说明轮播图里面没有，不处理，正常执行
                }
            }
        }catch (Exception e){
            throw new RuntimeException("活动下架失败");
        }
    }
}
