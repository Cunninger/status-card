//package com.followjs.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//
//@Configuration
//public class WebConfig {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver(){
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/src/main/resources/templates/");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
//}