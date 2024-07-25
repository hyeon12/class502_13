package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.entities.MemberProfile;
import org.choongang.member.repositories.MemberProfileRepository;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class Ex10 {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberProfileRepository profileRepository;
    @PersistenceContext
    private EntityManager em; //테스트에서 쿼리 실행 되는지 확인하기 위해 비우는 것

    @BeforeEach
    void init(){
        //테스트 이전 테스트 데이터 넣기
        MemberProfile profile = MemberProfile.builder()
                .profileImage("이미지")
                .status("상태")
                .build();
        profileRepository.saveAndFlush(profile);

        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .profile(profile)
                .build();
        memberRepository.saveAndFlush(member);

        em.clear();
    }

    @Test
    void test1(){
        Member member = memberRepository.findById(1L).orElse(null);
        MemberProfile profile = member.getProfile();
        System.out.println(profile);
    }

    @Test
    void test2(){
        MemberProfile profile = profileRepository.findById(1L).orElse(null);
        Member member = profile.getMember();
        System.out.println(member);
    }

}
