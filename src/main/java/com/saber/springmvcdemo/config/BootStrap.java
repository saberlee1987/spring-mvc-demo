package com.saber.springmvcdemo.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class BootStrap implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext context) throws ServletException {

        AnnotationConfigWebApplicationContext rootContextConfig = new AnnotationConfigWebApplicationContext();
        rootContextConfig.register(RootContextConfig.class);
        context.addListener(new ContextLoaderListener(rootContextConfig));

        AnnotationConfigWebApplicationContext webServletConfig = new AnnotationConfigWebApplicationContext();
        webServletConfig.register(WebServletConfig.class);

        ServletRegistration.Dynamic dispatcherServlet = context.addServlet("springDispatcherServlet", new DispatcherServlet(webServletConfig));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}
