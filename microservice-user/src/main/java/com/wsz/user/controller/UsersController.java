package com.wsz.user.controller;


import com.wsz.user.controller.vo.LoginReqVO;
import com.wsz.user.service.IUsersService;
import com.wsz.utils.util.JwtTokenUtil;
import com.wsz.utils.common.vo.BaseResponseVO;
import com.wsz.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsz
 * @since 2021-04-29
 * @description : 用户模块表现层
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVO login(@RequestBody LoginReqVO loginReqVO) throws CommonServiceException {

        //数据验证
        loginReqVO.checkParam();

        //验证用户名和密码是否正确
        String userId = iUsersService.checkUserLogin(loginReqVO.getUsername(), loginReqVO.getPassword());

        //JWT验证
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();

        String token = jwtTokenUtil.generateToken(userId, randomKey);

        /**
         * createTime 过期时间
         * randomkey - JWT数据签名： AES -> 源数据 + 盐 -> 在token中解析出randomkey -> 数据验签
         * userid - 用户身份验证
         */

        // randomKey  token
        Map<String,String> result = new HashMap<>();
        result.put("randomKey", randomKey);
        result.put("token", token);

        return BaseResponseVO.success(result);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }





}
