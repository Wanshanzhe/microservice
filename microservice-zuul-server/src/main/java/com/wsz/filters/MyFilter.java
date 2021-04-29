package com.wsz.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author by 完善者
 * @date 2021/4/29 16:48
 * @DESC
 */
@Slf4j
public class MyFilter extends ZuulFilter {
    /**
     * filter类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序（越大排序越靠后）
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要拦截
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * filter具体的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // ThreadLocal
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            log.info("headNames:{},headValues:{}",headName,request.getHeader(headName));
        }
        return null;
    }
}
