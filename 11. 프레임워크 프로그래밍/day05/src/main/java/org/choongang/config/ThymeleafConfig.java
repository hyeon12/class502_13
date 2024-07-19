package org.choongang.config;

import lombok.RequiredArgsConstructor;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@RequiredArgsConstructor
public class ThymeleafConfig implements WebMvcConfigurer {
    private final WebApplicationContext applicationContext;

    /* 템플릿 설정 , 문법 , 번역 관련 ... */

    @Bean
    public SpringResourceTemplateResolver templateResolver() { //템플릿 경로 설정
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates2/"); //템플릿 경로
        templateResolver.setSuffix(".html");
            // 확장자 html? 내츄럴 템플릿 지향 - 번역 작업 시 내부 값 x, 속성 형태로 정의
        templateResolver.setCacheable(false);
            // 캐시 설정 (한번 템플릿 번역된 파일 - 새로 만드는 것이 아닌! 로딩된 파일 계속 사용)
            // => 개발 시에는 요청시마다 바뀌어야 작업내용 반영되므로 false 로!
            // -> 배포 시에는 true 로 !
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); //EL 식 속성 번역 O - 데이터 넘기면 EL식으로 사용!
        templateEngine.addDialect(new Java8TimeDialect()); //확장 기능 추가 - addDialect()
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }
}
