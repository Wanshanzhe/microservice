package com.wsz.user.service;

import com.wsz.user.dao.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsz.utils.exception.CommonServiceException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wsz
 * @since 2021-04-29
 */
public interface IUsersService extends IService<Users> {

    String checkUserLogin(String username,String password) throws CommonServiceException;
}
