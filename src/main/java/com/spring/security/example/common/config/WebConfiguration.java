package com.spring.security.example.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport{

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
	    registry.addRedirectViewController("/", "/login");
    }

    
}
