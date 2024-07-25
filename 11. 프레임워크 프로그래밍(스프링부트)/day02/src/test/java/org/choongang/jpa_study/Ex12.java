package org.choongang.jpa_study;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.board.entities.BoardData;
import org.choongang.board.entities.QBoardData;
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
public class Ex12 {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private JPAQueryFactory queryFactory; //DBConfig 쪽에 미리 조립! -> 가져다 쓰면 된ㄷㅏ~

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
        List<BoardData> items = boardDataRepository.findAll();

        for(BoardData item : items){
            Member member = item.getMember();
            String email = member.getEmail();
            String userName = member.getUserName();
            System.out.printf("email: %s, userName: %s%n", email, userName);
        }
    }

    @Test
    void test2(){
        List<BoardData> items = boardDataRepository.getAllList();
    }

    @Test
    void test3(){
        List<BoardData> items = boardDataRepository.findBySubjectContaining("제목");
    }

    @Test
    void test4(){
        QBoardData boardData = QBoardData.boardData;
        //JPA 엔티티 클래스 기반으로 생성, 해당 엔티티 클래스의 필드와 관련된 쿼리 작성 지원 Q!

        //JPAQueryFactory factory = new JPAQueryFactory(em); //생성자 매개변수 EntityManager
        JPAQuery<BoardData> query = queryFactory
                .selectFrom(boardData)
                .leftJoin(boardData.member) // boardData 안쪽 속성인 member (Qmember X)
                .fetchJoin();

        List<BoardData> items = query.fetch();
        //items.forEach(System.out::println);
    }

    @Test
    void test5(){
        QBoardData boardData = QBoardData.boardData;
        // 데이터가 한 개일 때는 JPAQuery<String> query / JPAQuery<Long> 처럼 지정해서 사용
        // 두 개 이상인 경우 Tuple ...
        JPAQuery<Tuple> query = queryFactory.select(boardData.subject, boardData.content)
                .from(boardData);
        List<Tuple> items = query.fetch();
        for(Tuple item : items){
            String subject = item.get(boardData.subject);
            String content = item.get(boardData.content);
            System.out.printf("subject=%s, content=%s%n", subject, content);
        }
    }

    @Test
    void test6(){
        QBoardData boardData = QBoardData.boardData;
        JPAQuery<Long> query = queryFactory.select(boardData.seq.sum())
                .from(boardData);
    }

}
