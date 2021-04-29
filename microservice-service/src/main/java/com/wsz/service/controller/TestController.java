package com.wsz.service.controller;

import com.wsz.api.user.vo.LoginReqVO;
import com.wsz.service.apis.UserFeignApi;
import com.wsz.utils.common.vo.BaseResponseVO;
import com.wsz.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author by 完善者
 * @date 2021/4/29 19:00
 * @DESC 测试其他微服务
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserFeignApi userFeignApi;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVO login(@RequestBody LoginReqVO loginReqVO) throws CommonServiceException {
        return userFeignApi.login(loginReqVO);
    }

}
