package tests;

import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LoginServiceTest {

    private LoginService loginService;
    private HttpServletRequest request;

    @BeforeEach
    void init(){
        //각 단위테스트 전 객체생성 이루어짐.
        loginService = new LoginService(); //객체생성
    }

    /**
     * 로그인 성공을 위해
     * 1. 아이디가 존재하는지?
     * 2. 아이디와 비밀번호가 데이터에 저장된 것과 동일한지?
     */
    @Test
    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    void successTest(){
        //예외가 발생하지 않으면 통과
        assertDoesNotThrow(() -> {
           loginService.process(request);
        });
    }
}
