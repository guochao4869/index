package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.JournalismResult;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface JournalismResultMapper extends Mapper<JournalismResult> {

    @Select("select j1.id,j2.name,j2.writer,j2.time,j2.source,j1.details_id,j1.state,j2.img,j1.Slideshowsign from index_journalism j1,index_journalism_content j2 where j1.details_id =j2.id ")
    List<JournalismResult> findJournalismlist();

    List<JournalismResult> conditionquery(JournalismResult journalismResult);


}
