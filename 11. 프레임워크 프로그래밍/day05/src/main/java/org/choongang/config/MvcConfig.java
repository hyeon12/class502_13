package org.choongang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //웹에 대한 설정 클래스
@EnableWebMvc
@ComponentScan("org.choongang") //스캔 범위
public class MvcConfig implements WebMvcConfigurer {
    //웹 설정에 대한 틀 (@interface WebMvcConfigurer)
    //HandlerMapping, HandlerAdapter, ViewResolver

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
