package tests;

import global.exceptions.ValidationException;
import member.controllers.RequestJoin;
import member.services.JoinService;
import member.validators.JoinValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입기능 테스트")
public class JoinServiceTest {

    private JoinService joinService; //테스트마다 독립적인 데이터 유지가 필요하기 때문에


    @BeforeEach
    void init(){
        joinService = new JoinService(new JoinValidator());
    }

    RequestJoin getData(){
        return RequestJoin.builder()
                .email("test" + System.currentTimeMillis() + "@test.org")
                .password("12345678")
                .confirmPassword("12345678")
                .userName("사용자")
                .termsAgree(true)
                .build();
    }

    @Test
    @DisplayName("회원가입 성공시 예외 발생X")
    void successTest(){
        assertDoesNotThrow(() -> {
            joinService.process(getData());
            /* 리팩토링~!
            JoinService service = new JoinService(new JoinValidator());
            //service.process(); - 간단
            //TDD 테스트 간단 -> 복잡
            RequestJoin form = RequestJoin.builder().build();
            service.process(form);
             */
        });
    }

    //테스트 주도 개발 시나리오 -> 단계별로 작성
    @Test
    @DisplayName("필수항목(이메일, 비밀번호, 비밀번호 확인, 회원명, 약관동의) 검증, 검증 실패시 ValidationException 발생")
    void requiredFieldTest() {
        assertAll(
            //이메일 검증
            () -> {
                RequestJoin form = getData();
                form.setEmail(null);
                requiredFieldEachTest(form, "이메일");

                form.setEmail("     ");
                requiredFieldEachTest(form, "이메일");
            },
            // 비밀번호 검증
            () -> {
                RequestJoin form = getData();
                form.setPassword(null);
                requiredFieldEachTest(form, "비밀번호");

                form.setPassword("     ");
                requiredFieldEachTest(form, "비밀번호");
            },
            // 비밀번호 확인 검증
            () -> {
                RequestJoin form = getData();
                form.setConfirmPassword(null);
                requiredFieldEachTest(form, "비밀번호를 확인");

                form.setConfirmPassword("     ");
                requiredFieldEachTest(form, "비밀번호를 확인");
            },
            // 회원명 검증
            () -> {
                RequestJoin form = getData();
                form.setUserName(null);
                requiredFieldEachTest(form, "회원명");

                form.setUserName("    ");
                requiredFieldEachTest(form, "회원명");
            },
            () -> {
                RequestJoin form = getData();
                form.setTermsAgree(false);
                requiredFieldEachTest(form, "약관에 동의");
            });

    }

    //form에 keyword가 포함되어 있는지 체크
    void requiredFieldEachTest(RequestJoin form, String keyword){
        ValidationException thrown = assertThrows(ValidationException.class, () -> {
            joinService.process(form);
        }, keyword + " 오류! "); //테스트가 실패했을때 keyword(message)로 어떤 오류인지 알기 쉽게~~!

        String message = thrown.getMessage();
        assertTrue(message.contains(keyword));
    }

    @Test
    @DisplayName("비밀번호와 비밀번호 확인 일치 테스트, 검증 실패시 ValidationExcetpion 발생")
    void passwordMatchTest(){}

    @Test
    @DisplayName("이메일 중복 여부 테스트, 검증 실패시 DuplicatedMemberExcetpion 발생")
    void duplicateEmailTest(){}

    //회원가입 과정에서 검증 후 문제가 없다면, 회원가입이 끝났을 때 db 테이블에 저장 -> 조회해보고 실제 저장되었는지 확인(DB 조회를 통해 저장 되었는지 확인)

    @Test
    @DisplayName("회원 가입 후 실제 데이터 베이스에서 조회 되는지 검증")
    void memberExistsTest(){
        //가입 처리

        //getData() 로 생성한 데이터의 email 항목으로 DB 조회

        //조회한 회원 데이터 email과 getData()로 생성된 email이 일치하는지 체크
        //assertEquals(...)
    }
}
