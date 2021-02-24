package com.shangxin.demo.dao;

import com.shangxin.demo.pojo.Login;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface LoginMapper extends Mapper<Login> {

    @Select("select *from admin where username=#{username} and password=#{password}")
    Login login(@Param(value = "username") String username,@Param(value = "password") String password);

    @Select("select *from admin where username=#{username}")
    Login loginusername(String username);
}
