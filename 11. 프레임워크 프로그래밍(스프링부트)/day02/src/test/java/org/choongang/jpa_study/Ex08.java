package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class Ex08 {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init(){
        em.setFlushMode(FlushModeType.AUTO); // 자동 플러시 활성화~! (쿼리 실행 전 변경사항이 모두 플러시되도록)

        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .build();
        memberRepository.saveAndFlush(member);

        em.clear(); //영속성 비워내기 - 쿼리 실행 여부 확인하기 위함
        // 영속성 컨텍스트를 비우면, 다음에 엔티티에 접근할 때 캐시가 아닌 데이터 베이스에서 가져옴.
    }

    @Test
    void test1(){
        //FlushModeType.AUTO를 설정 -> 쿼리 실행 전에 모든 변경사항이 플러시되도록 보장
        //=> 최신 데이터가 데이터베이스에서 조회되도록 한다!
        Member member = memberRepository.findById(1L).orElse(null);
        member.setUserName("테스트!");

        List<Member> members = memberRepository.findAll();
        members.forEach(System.out::println);

        em.clear(); // 영속성 비운 후에도 DB에 동일한 결과인지!

        List<Member> members2 = memberRepository.findAll();
        members2.forEach(System.out::println);
    }
}
