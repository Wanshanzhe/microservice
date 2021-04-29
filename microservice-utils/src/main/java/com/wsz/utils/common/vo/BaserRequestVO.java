package com.wsz.utils.common.vo;

import com.wsz.utils.exception.CommonServiceException;

/**
 * @author : wsz
 * @program : com.wsz.utils.common.vo
 * @description : 公共的请求对象
 **/
public abstract class BaserRequestVO {

    /**
    * @Description: 公共的参数验证方法
    * @Param: []
    * @return: void
    * @Author: jiangzh
    */
    public abstract void checkParam() throws CommonServiceException, CommonServiceException;

}
