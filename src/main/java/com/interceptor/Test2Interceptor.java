package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器  实现HandlerInterceptor接口
 * Created by frostpig on 2018/3/23.
 */
public class Test2Interceptor implements HandlerInterceptor{
    //这里返回值表示：是否要将当前的请求拦截下来
    // 如果返回false,请求将被终止
    // 如果返回true,请求会被继续运行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("执行到了preHandle2方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("msg","从拦截器返回的数据");
        System.out.println("执行到了postHandle2方法");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("执行到了afterCompletion2方法");

    }
}
