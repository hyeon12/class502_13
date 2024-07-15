package org.choongang.config;

import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;

@Configuration //웹에 대한 설정 클래스
@EnableWebMvc
@ComponentScan("org.choongang") //스캔 범위
@Import(value={DBConfig.class, MessageConfig.class})
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    //웹 설정에 대한 틀 (@interface WebMvcConfigurer)
    //HandlerMapping, HandlerAdapter, ViewResolver

    //private final JoinValidator joinValidator;

    // 모든 컨트롤러에 적용될 수 있는 전역 Validator
    /*
    @Override
    public Validator getValidator() {
        return joinValidator;
    }
    */

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //정적 경로 설정
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index"); //뷰만 연동해서 main 경로를 지정 가능

        registry.addViewController("/mypage/**")
                .setViewName("mypage/index");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
