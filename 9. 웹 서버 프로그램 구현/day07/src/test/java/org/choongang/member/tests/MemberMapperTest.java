package org.choongang.member.tests;

import com.github.javafaker.Faker;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("매핑...테스트...?")
public class MemberMapperTest {

    private SqlSession session;
    private MemberMapper mapper;

    @BeforeEach
    void init(){
        session = DBConn.getSession(false);
        mapper = session.getMapper(MemberMapper.class);
    }

    @Test
    @DisplayName("회원 등록, 조회 테스트")
    void registerTest(){
        Member member = new Member();
        Faker faker = new Faker(Locale.ENGLISH);
        member.setEmail(System.currentTimeMillis() + faker.internet().emailAddress());
        member.setPassword(faker.regexify("\\w{8,16}").toLowerCase());
        member.setUserName(faker.name().fullName());

        int result = mapper.register(member); //등록
        assertEquals(1, result); //반영 레코드 개수 = 1이 나와야함

        long cnt = mapper.exist(member.getEmail()); //등록 회원 있는지 테스트 (email 로 조회)
        assertEquals(1L, cnt);

        Member member2 = mapper.get(member.getEmail()); //이메일로 조회되는 회원이 있는지 테스트
        assertEquals(member.getEmail(), member2.getEmail());//등록한 회원과 조회한 회원의 정보 일치하는지?
    }

    @AfterEach
    void destroy(){
        session.rollback();
    }
}
