package com.shangxin.demo.service;

import com.shangxin.demo.pojo.ActivityContent;
import com.shangxin.demo.pojo.TwoList;
import org.apache.ibatis.annotations.Update;

/**
 * 活动详情的服务
 */
public interface ActivityContentService {

    /**
     * 查看活动的详情上架的
     * @param detailsid
     * @return
     */
    ActivityContent findActivityContent(int detailsid);

    /**
     * 查看活动的详情所有的的
     * @param detailsid
     * @return
     */
    ActivityContent findActivityContentAll(int detailsid);

    /**
     * 新增活动
     * @param activityContent
     */
    void insertActivityContent(ActivityContent activityContent);

    /**
     * 修改活动
     * @param activityContent
     */
    void updateActivityContent(ActivityContent activityContent);

    /**
     * 批量下架
     * @param twoList
     */
    void soldout(TwoList twoList);

    /**
     * 批量上架
     * @param twoList
     */
    void putaway(TwoList twoList);
}
