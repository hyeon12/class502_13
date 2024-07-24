package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex04 {

    @PersistenceContext
    private EntityManager em;

    @Test
    void test1() throws Exception {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setUserName("김사용");

        em.persist(member);
        em.flush();

        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.printf("createAt: %s, modifiedAt: %s%n", member.getCreatedAt(), member.getModifiedAt());

        Thread.sleep(5000);
        member.setUserName("(수정)김사용");
        em.flush();
        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.printf("createAt: %s, modifiedAt: %s%n", member.getCreatedAt(), member.getModifiedAt());
    }
}
