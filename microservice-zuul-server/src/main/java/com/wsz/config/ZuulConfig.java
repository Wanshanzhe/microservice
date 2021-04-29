package com.wsz.config;

import com.wsz.filters.JWTFilter;
import com.wsz.filters.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by 完善者
 * @date 2021/4/29 14:54
 * @DESC
 */
@Configuration
public class ZuulConfig {

    @Bean
    public MyFilter myFilter(){
        return new MyFilter();
    }

    @Bean
    public JWTFilter initJWTFilter(){
        return new JWTFilter();
    }
}
