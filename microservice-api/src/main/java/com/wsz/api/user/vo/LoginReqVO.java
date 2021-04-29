package com.wsz.api.user.vo;

import com.wsz.utils.common.vo.BaserRequestVO;
import com.wsz.utils.exception.CommonServiceException;
import com.wsz.utils.util.ToolUtils;
import lombok.Data;

/**
 * @author by 完善者
 * @date 2021/4/29 10:48
 * @DESC
 */
@Data
public class LoginReqVO extends BaserRequestVO {

    private String username;
    private String password;


    @Override
    public void checkParam() throws CommonServiceException {
        //TODO 验证数据合法性
        if (ToolUtils.strIsNull(username) || ToolUtils.strIsNull(password)){
            throw new CommonServiceException(404, "username 或 password不能为空");
        }
    }
}
