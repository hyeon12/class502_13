package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test") //설정 안하면 oracleDB 로 실행됨
public class Ex02 {

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init(){
        for(long i = 1L; i <= 10L; i ++){
            Member member = new Member();
            //member.setSeq(i);
            member.setEmail("user0" + i + "@test.org");
            member.setPassword("12345678");
            member.setUserName("사용자0" + i);
            member.setCreatedAt(LocalDateTime.now());
            em.persist(member); // 영속 상태
        }
        //처음 만든 객체 - insert 실행됨
        em.flush(); // DB 영구 반영
        em.clear(); // 영속 상태 엔티티 모두 비우기
    }

    @Test
    void test1(){
        //find() 두번째 매개변수 -> 기본키
        Member member = em.find(Member.class, 1L);
        System.out.println(member);
        em.clear();

        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);

        System.out.println(member == member2);
        System.out.println("member:" + System.identityHashCode(member));
        System.out.println("member2:" + System.identityHashCode(member2));

        member.setUserName("(수정)사용자00");

        //em.flush(); //UPDATE 쿼리 실행
        // 값 변경후, 삭제 상태 변경 후 해당 데이터를 조회 -> 암묵적으로 flush()
        // 변경된 데이터를 조회해야 하므로 manager가 반영해주는 것
        Member member3 = em.find(Member.class, 1L);
        System.out.println(member3);
    }
}
