package org.choongang.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.RequiredArgsConstructor;
import org.choongang.member.validators.JoinValidator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration //웹에 대한 설정 클래스
@EnableWebMvc
@ComponentScan("org.choongang") //스캔 범위
/*@Import(value={DBConfig.class,
        MessageConfig.class,
        InterceptorConfig.class,
        FileConfig.class})*/
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
        //정적 리소스의 경로 설정
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 특정 URL 경로에 대해 직접 뷰를 연결
        registry.addViewController("/")
                .setViewName("main/index"); //뷰만 연동해서 main 경로를 지정 가능

        registry.addViewController("/mypage/**")
                .setViewName("mypage/index");
    }

    /*
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
    */

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        String fileName = "application";
        String profile = System.getenv("spring.profiles.active");
        fileName += StringUtils.hasText(profile) ? "-" + profile : "";

        /**
         * spring.profiles.active = dev
         * -> application-dev
         * spring.profiles.active = prod
         * -> application-prod
         **/

        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(new ClassPathResource(fileName + ".properties"));
        //conf.setLocations(new ClassPathResource("application.properties"));
        return conf;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json() // 응답 하는 형식
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
                .build();

        converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
