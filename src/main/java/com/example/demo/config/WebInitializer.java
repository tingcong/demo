package com.example.demo.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.Registration;
import javax.servlet.ServletRegistration;

/**
 *  WebApplicationInitializer替代web.xml的功能
 * Created by hutingcong on 2017/7/30.
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(MyMVCConfig.class);
        //新建WebApplicationContext,註冊配置类，并将其和当前servletContext关联
        ctx.setServletContext(servletContext);

        //注册springMVC的dispatchServlet
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
