package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
//@Transactional
//레포지토리에는 트랜잭션 처리 안해도 되지만, 지연로딩의 경우에는 꼭 써야함
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05 {
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init(){
        // 여러 개의 데이터 -> 목록 형태로 만들어서 saveAll~ 해주는 것이 좋다!
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                .email("user0" + i + "@test.org")
                .password("12345678")
                .userName("4용자0" + i)
                .authority(Authority.USER)
                .build()).toList();

        memberRepository.saveAllAndFlush(members);

        /*
        복수 개의 데이터를 넣는 경우
        낱개로 넣는 것보다, 리스트 형태로 가공하는 것이 좋다
        for(int i = 0; i <= 10; i++) {
            Member member = Member.builder()
                    .email("user0" + i + "@test.org")
                    .password("12345678")
                    .userName("4용자0" + i)
                    .authority(Authority.USER)
                    .build();

            memberRepository.save(member);
        }

        memberRepository.flush();
         */

        /*
        memberRepository.save(member); //persist()
        memberRepository.flush(); //DB 영구 반영
        한번에 처리할 수 있는 메서드 */
        //memberRepository.saveAndFlush(member);

    }

    @Test
    void test1(){
        Member member = memberRepository.findById(1L).orElse(null);//조회 메서드(기본키)
        System.out.println(member);

        member.setUserName("(수정)사용자!");
        memberRepository.save(member); //값 바꾸면 꼭 save 해야 반영됨!!~~~

        //memberRepository.flush(); //save 없이 flush만 하자 반영 안됐음

        Member member2 = memberRepository.findById(1L).orElse(null);
        System.out.println(member2);

        memberRepository.delete(member2);
        //System.out.println(member2);
        //memberRepository.flush(); - 테스트 종료되면서 clear() 됐기 때문에
    }

    @Test
    void test2(){
        List<Member> members = memberRepository.findAll();
        members.forEach(System.out::println);
        //System.out.println(members.stream().toList());
    }

}
