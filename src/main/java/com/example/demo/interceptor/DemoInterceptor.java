package com.example.demo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * Created by hutingcong on 2017/7/30.
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
        long startTime=(long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime=System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+new Long(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }

    @Bean   //配置拦截器的bean
    public DemoInterceptor demoInterceptor(){
        return  new DemoInterceptor();
    }
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }
}
