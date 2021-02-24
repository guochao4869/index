package com.shangxin.demo.controller;

import com.shangxin.demo.pojo.Member;
import com.shangxin.demo.pojo.Result;
import com.shangxin.demo.service.LoginService;
import com.shangxin.demo.utils.BCrypt;
import com.shangxin.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.HashMap;
import java.util.Random;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/Login")
    public Result login(@RequestBody HashMap<String, String> map,  HttpServletResponse response){
        //验证用户名和密码
        String username = map.get("username");
        String password = map.get("password");
        boolean login = loginService.login(username, password);
        if (login==true){
            Random random=new Random();
            Integer i = random.nextInt();
            String ito = i.toString();
            //登入如果验证成功就放cookie
            Member member = new Member();
            member.setId(ito);
            member.setNickname(ito);
            member.setAvatar(ito);
            String jwt = JwtUtils.generateJwt(member);

            Cookie cookie=new Cookie("mycookid",jwt);
            cookie.setMaxAge(60*30);

            response.addCookie(cookie);

            return new Result(true,"登入成功");
        }else {
            return new Result(false,"用户名或密码不存在");
        }
    }

    @RequestMapping(value = "/setCookies",method = RequestMethod.GET)
    public String setCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息类
        //HttpServerletRespionse 装相应信息的类
        Cookie cookie=new Cookie("sessionId","CookieTestInfo");
        response.addCookie(cookie);
        return "获得cookies信息成功";
    }

    public static void main(String[] args) {
        String admin="admin";
        byte[] bytes = admin.getBytes();
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println("加密前："+admin+"加密后："+s);
        String hashpw1 = BCrypt.hashpw(admin, BCrypt.gensalt());
        String hashpw2 = BCrypt.hashpw(admin, BCrypt.gensalt());
        System.out.println(hashpw1);
        System.out.println(hashpw2);
        String testpassowrd="admin";
        boolean checkpw = BCrypt.checkpw(testpassowrd, hashpw1);
        System.out.println(checkpw);

    }

    @GetMapping("/deletecookie")
    public Result deletecookie(HttpServletResponse response){
        Cookie cookie=new Cookie("mycookid","");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        return new Result(true,"cookie设置为空成功");
    }


}
