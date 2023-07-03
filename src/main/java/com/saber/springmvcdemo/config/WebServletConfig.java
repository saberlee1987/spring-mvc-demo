package com.saber.springmvcdemo.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpHost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.saber.springmvcdemo.site"
        , useDefaultFilters = false, includeFilters = @ComponentScan.Filter({Controller.class, ControllerAdvice.class}))

public class WebServletConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        HttpClient client = HttpClientBuilder.create()
                .setProxy(new HttpHost("192.168.100.165",3128))
                .build();

        clientHttpRequestFactory.setConnectTimeout(10000);
        clientHttpRequestFactory.setConnectionRequestTimeout(30000);
        clientHttpRequestFactory.setHttpClient(client);
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }
}
