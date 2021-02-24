package com.shangxin.demo.service.impl;

import com.shangxin.demo.dao.LoginMapper;
import com.shangxin.demo.pojo.Login;
import com.shangxin.demo.service.LoginService;
import com.shangxin.demo.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;


    /**
     * 登入接口
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username,String password) {
        //根据用户名去查询是否有该用户
        Login login = loginMapper.loginusername(username);
        if (login==null){
            return false;
        }
        //如果有该用户就获取该用户的密码与页面输入的密码解密做验证，如果为true就是相同，允许登入
        String turepassword = login.getPassword();
        boolean checkpw = BCrypt.checkpw(password, turepassword);

        //使用 new BCryptPasswordEncoder() 进行加密的密码
        if (checkpw ==true ){
            return true;
        }
        return false;
    }

    /**
     * 查询出来用户名和密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public Login tologin(String username, String password) {
        Login login = loginMapper.login(username, password);
        return login;
    }

}
