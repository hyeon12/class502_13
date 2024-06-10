package exam01;

import com.github.javafaker.Faker;
import global.Mailer;
import jakarta.servlet.http.HttpServletRequest;
import member.services.LoginService;
import member.validators.LoginValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class Ex02Test {

    private LoginService loginService;
    @Mock
    private Mailer mailer; //호출되었는지 확인하기 위해 모의객체 생성
    @Mock
    private HttpServletRequest request; //모의객체 생성
    private Faker faker;

    @BeforeEach
    void init(){
        loginService = new LoginService(new LoginValidator());
        //mailer = mock(Mailer.class); //Mockito.mock() 특정 타입의 모의객체 생성1
        //request = mock(HttpServletRequest.class);//모의객체 생성2
        //모의객체를 따로 생성하지 않고 애노테이션으로 실행 가능하다~! @Mock
        faker = new Faker(Locale.ENGLISH);

        //스텁(Stub) 추가
        given(request.getParameter("email")).willReturn(faker.internet().emailAddress());
        given(request.getParameter("password")).willReturn(faker.regexify("\\w{8}".toLowerCase()));
    }

    //특정 기능에서 특정 함수가 호출되는지 체크 - should()
    //로그인 성공 시, 메일전송-send()함수
    @Test
    void test1(){
        loginService.setMailer(mailer);
        loginService.process(request);
        String email = request.getParameter("email");
        //send 함수가 loginService.process 메서드에서 한 번 이상 호출되는지 테스트
        //then(mailer).should().send(email);
        then(mailer).should(only()).send(email); // only() : 한번만 호출되는지 테스트
    }

    @Test
    void test2(){
        loginService.setMailer(mailer);
        loginService.process(request);
        String email = request.getParameter("email");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        then(mailer).should().send(captor.capture());

        String usedEmail = captor.getValue(); //send 메서드에서 매개변수로 사용한 값
        assertEquals(email, usedEmail);
    }
}
