package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class) //모의 객체 쓰기 위함
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private Faker faker;
    private RequestJoin form;
    private SqlSession dbsession;

    @Mock
    private HttpServletRequest request; //요청 데이터 모의객체로 생성 - stub

    @Mock
    private HttpSession session;

    @BeforeEach
    void init(){
        loginService = MemberServiceProvider.getInstance().loginService();
        JoinService joinService = MemberServiceProvider.getInstance().joinService();
        faker = new Faker(Locale.ENGLISH);
        dbsession = MemberServiceProvider.getInstance().getSession();
        //환경변수에 따라 변경되는 dbsession -> "Test"인 경우 autoCommit=false

        //회원 가입 -> 가입한 회원 정보로 email, password 스텁 생성
        form = RequestJoin.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase())
                .userName(faker.name().fullName())
                .termsAgree(true)
                .build();
        form.setConfirmPassword(form.getPassword());

        joinService.process(form); //회원가입

        //로그인
        setData();

        given(request.getSession()).willReturn(session);
    }

    //값이 담긴 상태
    void setData(){
        //setParam("email", faker.internet().emailAddress()); - 필수 입력항목 검증 시 임의 데이터 사용
        setParam("email", form.getEmail());//가입한 데이터로 입력
        setParam("password", form.getPassword());
    }

    void setParam(String name, String value){
        //매개변수(데이터)로 stub을 만드는 것
        given(request.getParameter(name)).willReturn(value);
    }

    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void successTest(){
        //assertDoesNotThrow(executable) : 예외 발생하지 않으면 통과
        assertDoesNotThrow(()->{
            loginService.process(request);
        });

        //로그인 처리 완료시 HttpSession - setAttribute 메서드가 호출됨
        then(session).should(only()).setAttribute(any(), any());
    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패시 BadRequestException 발생")
    void requiredFieldTest(){
        //사용자가 보내는 정보 -> getParameter
        assertAll(
                () -> requiredEachFieldTest("email", false, "이메일"),
                () -> requiredEachFieldTest("email", true, "이메일"),
                () -> requiredEachFieldTest("password", true, "비밀번호"),
                () -> requiredEachFieldTest("password", false, "비밀번호")
        );
    }

    //case 만드는 것 : null, "" -> 정확한 문구 출력되는지
    void requiredEachFieldTest(String name, boolean isNull, String message){
        setData(); //값을 초기화(이메일, 비밀번호 들어간 상태로)
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            if(name.equals("password")){//비밀번호 검증
                //null이거나 ""인 상황 set
                setParam("password", isNull?null:" ");
            }else{//이메일 검증
                setParam("email", isNull?null:" ");
            }

            loginService.process(request);
        }, name + "테스트");//어떤 테스트인지 명확하게 알기 위해 message

        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), name+", 키워드:" + message + "테스트"); //어떤 테스트가 출력되는지 알 수 있음(실패했을때만 출력되는 것으로, 어떤 부분에서 실패했는지 정확하게 알 수 있음)
    }

    @Test
    @DisplayName("이메일로 회원이 조회되는지 검증, 검증 실패시 BadRequestException 발생")
    void memberExistTest(){
        //회원가입이 선행되어야 검증 가능
        setParam("email", "****"+form.getEmail());//회원가입정보와 다른 데이터로 set
        BadRequestException thrown = assertThrows(BadRequestException.class,
                ()->{
            loginService.process(request);
                });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @Test
    @DisplayName("비밀번호 검증, 검증 실패시 BadRequestException 발생")
    void passwordCheckTest(){
        //비밀번호를 다르게 설정하고, 예외 발생하는지 체크해보자!
        setParam("password", "****"+form.getPassword());

        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            loginService.process(request);//입력한 데이터로 통과되는지 체크
        });

        String message = thrown.getMessage();
        //발생한 예외메세지가 같은지! (같아야 통과)
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @AfterEach
    void destroy(){
        //dbsession.rollback();
    }
}
