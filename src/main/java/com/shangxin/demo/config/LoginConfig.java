/*
package com.shangxin.demo.config;

import com.shangxin.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.Base64;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LoginConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    //做拦截，看权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                 http.authorizeRequests()

                         .antMatchers("/Content2/findgoods/**").hasRole("admin")
                         .antMatchers(HttpMethod.POST).hasRole("admin");
                         // 设置登陆页

                         //设置登入成功页面
                         //.defaultSuccessUrl("/index/home").permitAll();
                 //关闭csrf跨域
                 http.csrf().disable();

                 http.formLogin().loginPage("/login");
        //http.formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login").permitAll();\

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("admin")
                .and()
                .withUser("admin").password(Base64.getEncoder().encodeToString("admin".getBytes())).roles("admin");

       */
/* auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,role from login where username = ?")
                .withDefaultSchema()
                .withUser("user").password("admin").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");*//*

    }


}
*/
