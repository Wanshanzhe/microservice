package com.wsz.service.apis;

import com.wsz.api.user.UserFeignApis;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author by 完善者
 * @date 2021/4/29 18:45
 * @DESC
 */
@FeignClient(name = "microservice-user")
public interface UserFeignApi extends UserFeignApis {
}
