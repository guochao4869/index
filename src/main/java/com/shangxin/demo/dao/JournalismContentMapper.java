package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.JournalismContent;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 新闻详情持久层
 */
@org.apache.ibatis.annotations.Mapper
public interface JournalismContentMapper extends Mapper<JournalismContent> {

    @Select("select  p1.*from index_journalism_content p1,index_journalism p2 where p1.id=p2.details_id and p2.state=1 and p2.id=#{JournalismId}")
    JournalismContent findJournalismContent(int JournalismId);


}
