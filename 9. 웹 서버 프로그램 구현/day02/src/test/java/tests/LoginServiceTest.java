package tests;

import com.github.javafaker.Faker;
import global.exceptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("로그인 서비스 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private HttpServletRequest request; //사용자가 입력한 데이터
    private Faker faker;

    @BeforeEach
    void init(){ //각 단위테스트 실행 전마다 호출
        loginService = new LoginService(new LoginValidator());

        //mock(..) -> 가짜 데이터를 만들 수 있음
        //HttpServletRequest 모의 객체 생성
        request = mock(HttpServletRequest.class); //정보성객체 .class 를 넣어 가짜 객체 만들어짐

//        // (1) 반환값 willReturn (2) 예외 발생 willThrow
//        given(request.getParameter("email")).willReturn("test01@test.org");
//        //email이라는 매개변수가 입력되었을 때, 반환값으로 "test01@test.org"를 반환하겠다!
//        given(request.getParameter("password")).willReturn("12345678");
//        //스텁 설정 => 모의 객체의 메서드가 특정 값을 리턴하도록!
//
//        given(request.getParameter("123")).willThrow(IllegalArgumentException.class);
//        //인수 문제의 경우 해당 예외를 throw 한다는 조건으로 설정

        faker = new Faker(Locale.KOREAN);
    }

    void setParamData(String name, String value){ //직접 값 설정하게
        given(request.getParameter(name)).willReturn(value);
    }

    void setSuccessData(){//통과될 가짜 데이터 설정
        String password = faker.regexify("\\w{8}").toLowerCase();
        setParamData("email", faker.internet().emailAddress());
        setParamData("password", password);
    }

    @Test
    @DisplayName("로그인 성공 시 예외 발생 없음") //예외가 발생하지 않으면 통과!
    void successTest(){
        assertDoesNotThrow(()-> {
            setSuccessData(); //성공시 데이터 설정
            loginService.process(request); //로그인처리과정(사용자가 보낸 데이터)
        });
    }

    @Test
    @DisplayName("필수 입력 항목(아이디, 비밀번호) 검증, 검증 실패시 ValidationException 발생")
    //예외가 발생해야 통과! -> 잘못된 데이터가 들어왔을때 검증에 확실하게 실패하는지 체크하기 위함!!
    void requiredFieldTest(){//필수 항목 검증 - null, isBlank 체크
        assertAll(
                // 이메일 검증
                () -> requiredFieldEachTest("email", "이메일"),
                // 비밀번호 검증
                () -> {
                    setParamData("email", faker.internet().emailAddress());
                    requiredFieldEachTest("password", "비밀번호");
                }
        );
    }

    void requiredFieldEachTest(String name, String message){

        ValidationException thrown = assertThrows(ValidationException.class, () -> {
            //null
            loginService.process(request);

            //빈값
            setParamData(name, "    ");
            loginService.process(request);
        }, message + " 테스트");

        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), message + " 테스트");
    }

    @Test
    @DisplayName("이메일로 DB에서 회원이 조회되는지 검증, 검증 실패시 ValidationException 발생")
    void memberExistsTest(){

    }

    @Test
    @DisplayName("저장된 비밀번호와 일치하는지 검증, 검증 실패시 PasswordMismatchException 발생")
    void memberAuthTest(){

    }


}
