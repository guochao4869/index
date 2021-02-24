package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.ActivityContent;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface ActivityContentMapper extends Mapper<ActivityContent> {

    /**
     * 根据详情id去查询详情上架的
     * @param detailsid
     * @return
     */
    @Select("select p2.*from index_honorsandpatentsandactivity p1 ,index_activitycontent p2 where p1.details_id = p2.id and p1.state=1 and p1.details_id=#{detailsid}")
    ActivityContent findActivityContent(int detailsid);

    /**
     * 根据详情id去查询详情所有的的
     * @param detailsid
     * @return
     */
    @Select("select p2.*from index_honorsandpatentsandactivity p1 ,index_activitycontent p2 where p1.details_id = p2.id  and p1.details_id=#{detailsid}")
    ActivityContent findActivityContentAll(int detailsid);

    /**
     * 批量下架
     * @param id
     */
    @Update("update index_honorsandpatentsandactivity set state=0 where id=#{id}")
    void soldout(Integer id);

    /**
     * 批量上架
     * @param id
     */
    @Update("update index_honorsandpatentsandactivity set state=1 where id=#{id}")
    void putaway(Integer id);
}
