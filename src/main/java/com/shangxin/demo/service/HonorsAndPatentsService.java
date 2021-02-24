package com.shangxin.demo.service;

import com.github.pagehelper.PageInfo;
import com.shangxin.demo.dao.HonorsAndPatentsMapper;
import com.shangxin.demo.pojo.HonorsAndPatents;
import com.shangxin.demo.pojo.TwoList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HonorsAndPatentsService {

    /**
     * 查询所有上线的集团荣誉
     */
    List<HonorsAndPatents> findHonorsAll();

    /**
     * 查询所有上线的专利
     */
    List<HonorsAndPatents> findPatentsAll();

    /**
     * 查询所有上线的活动
     */
    List<HonorsAndPatents> findactivityAll();

    /**
     * 查询所有的集团荣誉
     */
    PageInfo findHonors(int currentpage);

    /**
     * 查询所有的专利
     * @return
     */
    PageInfo findPatents(int currentpage);

    /**
     * 查询所有的活动
     * @return
     */
    PageInfo findactivity(int currentpage);

    /**
     * 批量删除活动
     * @param twoList
     */
    void deleteactivity(TwoList twoList);

    /**
     * 新增集团荣誉
     * @param honorsAndPatents
     */
    void insertHonors(HonorsAndPatents honorsAndPatents);

    /**
     * 新增专利
     * @param honorsAndPatents
     */
    void insertPatents(HonorsAndPatents honorsAndPatents);

    /**
     * 修改集团荣誉和专利
     * @param honorsAndPatents
     */
    void updateHonorsAndPatents(HonorsAndPatents honorsAndPatents);

    /**
     * 批量上架专利或者荣誉
     * @param twoList
     */
    void putaway(TwoList twoList);

    /**
     * 批量下架专利或者荣誉
     * @param twoList
     */
    void soldout(TwoList twoList);

    /**
     * 批量删除荣誉和专利
     * @param twoList
     */
    void batchdelete(TwoList twoList);


}
