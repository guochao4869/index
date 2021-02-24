package com.shangxin.demo.service;

import com.shangxin.demo.pojo.Login;

/**
 * 登入的服务层
 */
public interface LoginService {

    /**
     * 登入接口
     * @param username
     * @param password
     * @return
     */
    boolean login(String username,String password);

    /**
     * 登入接口(查看用户名和密码)
     * @param username
     * @param password
     * @return
     */
    Login tologin(String username, String password);


}
