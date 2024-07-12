package org.choongang.member.controllers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class MemberControllerTest {

    @Autowired
    private WebApplicationContext ctx;
    //xml, annotation 등 많은 설정 방식이 있으므로 다형성 이용을 위해 WebApplicationContext!

    private MockMvc mockMvc; //의존성 주입x, 기본 설정으로 추가

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void test1() throws Exception{
        mockMvc.perform(
                post("/member/join")
                        .header("appKey", "1234") // 요청 헤더
                        .contentType(MediaType.APPLICATION_JSON_VALUE) // content-Type 상수 형태로 사용
                )
                .andDo(print()); //요청에 대한 모든 자세한 정보가 나옴. controller, 예외, 기타 정보 …
    }

    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/member/join")
                        .header("Accept-Language", Locale.KOREAN.getLanguage())
                )
                .andDo(print());

    }

}
