package org.choongang.member.repositories;

import org.choongang.config.MvcConfig;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;
    //DAO 역할

    @Test
    void test1(){
        List<Member> members = (List<Member>) repository.findAll();
        members.forEach(System.out::println);
    }

    @Test
    void test2(){
        Member member = Member.builder()
                .seq(1L)
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자(수정)")
                .build();

        repository.save(member);
        //기본 키가 있을 때는 UPDATE, 없을 때는 INSERT

    }

    @Test
    void test3(){
        Member member = repository.findById(1L).orElse(null);
        System.out.println(member);

        repository.delete(member);
    }

    @Test
    void test4(){
        Member member = repository.findByEmail("user05@test.org");
        System.out.println(member);
    }

    @Test
    void test5(){
        List<Member> members = repository.findByUserNameContaining("용자");
        members.forEach(System.out::println);
    }

    @Test
    void test6(){
        List<Member> members = repository.findByUserNameContainingAndEmailContainingOrderByRegDtDesc("용자", "user");
        members.forEach(System.out::println);
    }

    @Test
    void test7(){
        List<Member> members = repository.getMembers("%용자%", "%user%");
        members.forEach(System.out::println);
    }

}
