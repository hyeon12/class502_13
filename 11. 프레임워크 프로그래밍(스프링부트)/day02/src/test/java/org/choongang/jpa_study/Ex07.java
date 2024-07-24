package org.choongang.jpa_study;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.QMember;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex07 {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        // 여러 개의 데이터 -> 목록 형태로 만들어서 saveAll~ 해주는 것이 좋다!
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user0" + i + "@test.org")
                        .password("12345678")
                        .userName("사용자" + i)
                        .authority(i % 2 == 0 ? Authority.USER : Authority.ADMIN) //짝수면 USER, 홀수면 ADMIN
                        .build()).toList();

        memberRepository.saveAllAndFlush(members);
    }

    @Test
    void test1(){
        QMember member = QMember.member;
        BooleanExpression c1 = member.userName.contains("용");

        List<Member> members = (List<Member>)memberRepository.findAll(c1);

        members.forEach(System.out::println);
    }

    @Test
    void test2(){
        String key = "용";
        QMember member = QMember.member;
        BooleanBuilder andBuilder = new BooleanBuilder();
        BooleanBuilder orBuilder = new BooleanBuilder();
        orBuilder.or(member.email.contains(key))
                .or(member.userName.contains(key));

        andBuilder.and(orBuilder);

        List<Member> members = (List<Member>)memberRepository.findAll(andBuilder);
        members.forEach(System.out::println);
    }

    @Test
    void test3(){
        QMember member = QMember.member;
        BooleanExpression c1 = member.email.concat(member.userName).contains("용");
        //메서드 체이닝 방식 -> email 과 userName 결합하여 키워드 조회

        List<Member> members = (List<Member>)memberRepository.findAll(c1);
        members.forEach(System.out::println);
    }
}
