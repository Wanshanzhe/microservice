package com.wsz.fallbacks;

import com.alibaba.fastjson.JSONObject;
import com.wsz.utils.common.vo.BaseResponseVO;
import com.wsz.utils.exception.CommonServiceException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : wsz
 * @program : com.wsz.fallback
 * @description : 业务降级处理
 **/
@Component
public class MyFallback implements FallbackProvider {

    /**
    * @Description: 针对哪一个路由进行降级， return可以写 *
    * @Param: []
    * @return: java.lang.String
    * @Author: wsz
    */
    @Override
    public String getRoute() {
        return "film-service";
    }

    /**
    * @Description: 降级时处理方式
    * @Param: [route, cause]
    * @return: org.springframework.http.client.ClientHttpResponse
    * @Author: wsz
    */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            /**
            * @Description: 业务降级处理方式
            * @Param: []
            * @return: java.io.InputStream
            * @Author: wsz
            */
            @Override
            public InputStream getBody() throws IOException {
                BaseResponseVO responseVO
                        = BaseResponseVO.serviceException(
                        new CommonServiceException(404, "No Films!~"));
                String result = JSONObject.toJSONString(responseVO);
                return new ByteArrayInputStream(result.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
