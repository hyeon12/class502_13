package org.choongang.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc -> 스프링 부트 내에서 자동 실행
@EnableScheduling
@EnableJpaAuditing
@Configuration
public class MvcConfig implements WebMvcConfigurer {

}
