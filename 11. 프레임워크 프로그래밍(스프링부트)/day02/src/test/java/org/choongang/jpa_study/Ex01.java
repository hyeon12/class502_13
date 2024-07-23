package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01 {
    //@Autowired
    //private EntityManagerFactory emf;
    //@Autowired
    @PersistenceContext
    private EntityManager em;

    @Test
    void test1(){
        //EntityManager em = emf.createEntityManager();
        // 엔티티 매니저 = 엔티티를 상태 영속성 메모리에 넣어 관리

        //EntityTransaction tx = em.getTransaction();

        //tx.begin(); // Transaction 시작
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("사용자01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member); // persist() 영속성 메모리(변화 감지 메모리) 에 들어감 = 변화 감지 O

        em.flush(); //INSERT 쿼리

        em.detach(member); // 영속 상태 분리 - 변화 감지X -> flush 대상 아님

        member.setUserName("(수정)사용자01"); // 변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); //UPDATE 쿼리

        em.merge(member); // 분리된 영속 상태 -> 영속 상태(변화 감지 상태로)

        em.flush();

        //em.remove(member); // 제거 상태, 상태만 제거 상태
        //em.remove(em.contains(member) ? member : em.merge(member));
        //em.flush(); //DELETE 쿼리

        //tx.commit();
    }
}
