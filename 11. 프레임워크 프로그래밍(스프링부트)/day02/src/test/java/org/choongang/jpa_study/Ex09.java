package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
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
import java.util.stream.IntStream;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
// 관계 매핑의 경우, 원데이터가 사라지게 되면 오류 발생
// 원데이터의 영속 상태 유지시킬 수 있게 트랜잭션 사용
public class
Ex09 {

    /* 다대일, 일대다 */

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardDataRepository boardDataRepository;
    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init(){
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .build();

        memberRepository.saveAndFlush(member);

        List<BoardData> items = IntStream.rangeClosed(1, 10)
                        .mapToObj(i -> BoardData.builder()
                                .subject("제목"+i)
                                .content("내용"+i)
                                .member(member)
                                .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
        em.clear();
    }

    @Test
    void test1(){
        BoardData item = boardDataRepository.findById(1L).orElse(null);

        Member member = item.getMember(); //게시글을 작성한 회원
        //System.out.println(member); //주석처리하게 되면 getMember 실행X, 사용해야 쿼리 실행된다~!
    }

    @Test
    void test2(){
        Member member = memberRepository.findById(1L).orElse(null);
        List<BoardData> items = member.getItems();
        items.forEach(System.out::println);
    }

}
