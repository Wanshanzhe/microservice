package com.wsz.eureka.conf;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author : wsz
 * @program : com.wsz.eureka.conf
 * @description : SpringSecurity配置
 **/
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @Description: 对eureka注册的URL不进行CSRF防御
     * @Param: [http]
     * @return: void
     * @Author: wsz
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
