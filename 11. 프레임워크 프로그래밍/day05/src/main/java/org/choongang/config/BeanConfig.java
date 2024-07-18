package org.choongang.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean // 수동 등록 빈
    public ObjectMapper objectMapper(){
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        return om;
        /**
         * ObjectMapper 로 변환할 수 있는 방법 2가지 (test)Ex01 참고
         * 1)
         * 2)
         * */
    }
}
