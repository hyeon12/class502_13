package exam01;

import exam01.member.Assembler;
import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.services.JoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class Ex02 {

    @Test
    @DisplayName("의존성 주입 테스트")
    void test1(){
        Assembler assembler = new Assembler();
        JoinService joinService = assembler.joinService();
        MemberDao memberDao = assembler.memberDao();

        RequestJoin form = RequestJoin.builder()
                .email("user01@test.org")
                .userName("사용자01")
                .password("12345678")
                .confirmPassword("12345678")
                .build();

        joinService.process(form);

        List<Member> members = memberDao.getList();
        members.forEach(System.out::println);
    }
}
