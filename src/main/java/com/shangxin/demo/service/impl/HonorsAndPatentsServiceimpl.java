package com.shangxin.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangxin.demo.dao.ActivityContentMapper;
import com.shangxin.demo.dao.HonorsAndPatentsMapper;
import com.shangxin.demo.dao.SlideshowMapper;
import com.shangxin.demo.pojo.HonorsAndPatents;
import com.shangxin.demo.pojo.TwoList;
import com.shangxin.demo.service.HonorsAndPatentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HonorsAndPatentsServiceimpl implements HonorsAndPatentsService {

    @Autowired
    private HonorsAndPatentsMapper honorsAndPatentsMapper;

    @Autowired
    private ActivityContentMapper activityContentMapper;

    @Autowired
    private SlideshowMapper slideshowMapper;

    /**
     * 查询所有上线集团荣誉
     */
    @Override
    public List<HonorsAndPatents> findHonorsAll() {

        List<HonorsAndPatents> honorsAndPatentsMapperAll = honorsAndPatentsMapper.findHonorsAll();
        return honorsAndPatentsMapperAll;
    }

    /**
     * 查询所有的上线专利
     * @return
     */
    @Override
    public List<HonorsAndPatents> findPatentsAll() {

        List<HonorsAndPatents> findPatentsAll = honorsAndPatentsMapper.findPatentsAll();
        return findPatentsAll;
    }

    /**
     * 查询所有的上线的活动
     * @return
     */
    @Override
    public List<HonorsAndPatents> findactivityAll() {
        List<HonorsAndPatents> honorsAndPatents = honorsAndPatentsMapper.findactivityAll();
        return honorsAndPatents;
    }

    /**
     * 查询所有的集团荣誉
     * @return
     */
    @Override
    public PageInfo findHonors(int currentpage) {
        PageHelper.startPage(currentpage, 10);
        List<HonorsAndPatents> honorsAndPatents = honorsAndPatentsMapper.findHonors();
        PageInfo pageInfo=new PageInfo(honorsAndPatents);

        return pageInfo;
    }

    /**
     * 查询所有的专利
     * @return
     */
    @Override
    public PageInfo findPatents(int currentpage) {
        PageHelper.startPage(currentpage, 10);
        List<HonorsAndPatents> findPatentsAll = honorsAndPatentsMapper.findPatents();

        PageInfo pageInfo=new PageInfo(findPatentsAll);
        return pageInfo;
    }

    /**
     * 查询所有的活动
     * @return
     */
    @Override
    public PageInfo findactivity(int currentpage) {
        PageHelper.startPage(currentpage, 10);
        List<HonorsAndPatents> honorsAndPatents = honorsAndPatentsMapper.findactivity();
        PageInfo pageInfo=new PageInfo(honorsAndPatents);
        return pageInfo;
    }

    /**
     * 批量删除活动
     * @param twoList
     */
    @Transactional(rollbackFor = RuntimeException.class)   //开启事务，要么都成功，要么都失败
    @Override
    public void deleteactivity(TwoList twoList) {

        //获取详情id
        List<Integer> details_id = twoList.getDetails_id();

        try {
            for (Integer integer : details_id) {
                //循环遍历集合批量删除新闻详情
                activityContentMapper.deleteByPrimaryKey(integer);
                try {
                    slideshowMapper.batchdelete(integer,"活动");
                }catch (Exception e){
                    System.out.println("轮播图里面没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("删除活动详情失败");
        }

        //获取目录id
        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                //循环遍历集合批量删除新闻目录
                honorsAndPatentsMapper.deleteByPrimaryKey(integer);
            }
        }catch (Exception e){
            throw new RuntimeException("删除活动目录失败");
        }
    }

    /**
     * 新增荣誉
     * @param honorsAndPatents
     */
    @Override
    public void insertHonors(HonorsAndPatents honorsAndPatents) {
        //荣誉id1,写死
        honorsAndPatents.setState("0");
        honorsAndPatents.setClassify("1");
        honorsAndPatentsMapper.insert(honorsAndPatents);
    }

    /**
     * 新增专利
     * @param honorsAndPatents
     */
    @Override
    public void insertPatents(HonorsAndPatents honorsAndPatents) {
        //专利id为2.写死
        honorsAndPatents.setState("0");
        honorsAndPatents.setClassify("2");
        honorsAndPatentsMapper.insert(honorsAndPatents);
    }

    /**
     * 修改集团荣誉和专利
     * @param honorsAndPatents
     */
    @Override
    public void updateHonorsAndPatents(HonorsAndPatents honorsAndPatents) {
        //调用修改方法，根据id去修改
        try {

            honorsAndPatentsMapper.updateByPrimaryKey(honorsAndPatents);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("修改集团荣誉或专利出错");
        }

    }

    /**
     * 批量上架专利或者荣誉
     * @param twoList
     */
    @Transactional(rollbackFor = RuntimeException.class)   //开启事务，要么都成功，要么都失败
    @Override
    public void putaway(TwoList twoList) {
        //获取到传过来的id遍历然后调用上架方法
        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                honorsAndPatentsMapper.putaway(integer);
                try {
                    HonorsAndPatents list = honorsAndPatentsMapper.selectByPrimaryKey(integer);
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
                    slideshowMapper.putaway(integer,classify);
                }catch (Exception e){
                    System.out.println("轮播图里面没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("上架专利或者荣誉时失败");
        }

    }

    /**
     * 批量下架专利或者荣誉
     * @param twoList
     */
    @Transactional(rollbackFor = RuntimeException.class)   //开启事务，要么都成功，要么都失败
    @Override
    public void soldout(TwoList twoList) {
        //获取到传过来的id遍历然后调用下架方法
        List<Integer> id = twoList.getId();
        try {
            for (Integer integer : id) {
                honorsAndPatentsMapper.soldout(integer);
                try {
                    HonorsAndPatents list = honorsAndPatentsMapper.selectByPrimaryKey(integer);
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
                    slideshowMapper.soldout(integer,classify);
                }catch (Exception e){
                    //到这就说明数据库里面没有
                }
            }
        }catch (Exception e){
            throw new RuntimeException("下架专利或者荣誉时失败");
        }
    }


    /**
     * 批量删除专利或者荣誉
     * @param twoList
     */
    @Transactional(rollbackFor = RuntimeException.class)   //开启事务，要么都成功，要么都失败
    @Override
    public void batchdelete(TwoList twoList) {
        //获取到传过来的id遍历然后调用上架方法
        List<Integer> id = twoList.getId();

        try {
            for (Integer integer : id) {
                HonorsAndPatents list = honorsAndPatentsMapper.selectByPrimaryKey(integer);
                honorsAndPatentsMapper.deleteByPrimaryKey(integer);
                try {
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
                    slideshowMapper.batchdelete(integer,classify);
                }catch (Exception e){
                    System.out.println("轮播图里面没有");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("上架专利或者荣誉时失败");
        }

    }

}
