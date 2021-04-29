package com.wsz.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsz.user.dao.entity.Users;
import com.wsz.user.dao.mapper.UsersMapper;
import com.wsz.utils.exception.CommonServiceException;
import org.springframework.stereotype.Service;
import com.wsz.user.service.IUsersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wsz
 * @since 2021-04-29
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public String checkUserLogin(String username, String password) throws CommonServiceException {
        //根据用户名获取用户信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);

        List<Users> list = usersMapper.selectList(queryWrapper);
        Users users = null;
        if (list !=null && list.size()>0){
            users = list.stream().findFirst().get();
        }else {
            throw new CommonServiceException(404, "用户名输入有误");
        }

        if (!password.equals(users.getPassword())){
            throw new CommonServiceException(500,"用户密码输入有误");
        }else{
            return users.getId()+"";
        }
    }
}
