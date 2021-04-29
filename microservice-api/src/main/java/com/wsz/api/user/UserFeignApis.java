package com.wsz.api.user;

import com.wsz.api.user.vo.LoginReqVO;
import com.wsz.utils.common.vo.BaseResponseVO;
import com.wsz.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author by 完善者
 * @date 2021/4/29 22:00
 * @DESC
 */
public interface UserFeignApis {

    /**
     * 对外暴露登录接口服务
     * @param loginReqVO
     * @return
     */
    @RequestMapping(value = "/users/login",method = RequestMethod.POST)
    BaseResponseVO login(@RequestBody LoginReqVO loginReqVO) throws CommonServiceException;
}
