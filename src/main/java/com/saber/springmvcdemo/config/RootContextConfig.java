package com.saber.springmvcdemo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.nio.charset.StandardCharsets;

@Configuration
@ComponentScan(basePackages = "com.saber.springmvcdemo.site"
        , excludeFilters = @ComponentScan.Filter({Controller.class, ControllerAdvice.class}))
public class RootContextConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("messages", "validations");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setCacheMillis(-1);
        return messageSource;
    }

}
