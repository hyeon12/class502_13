package org.choongang.member.tests;

import com.github.javafaker.Faker;
import org.choongang.global.configs.DBConn;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.exceptions.DuplicatedMemberException;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("회원 가입 기능 테스트")
public class JoinServiceTest {
    //테스트 끝나면 -- 서비스 완성

    private JoinService service;
    private MemberMapper mapper;

    @BeforeEach //각 단위테스트 이전 실행
    void init(){
        service = MemberServiceProvider.getInstance().joinService();
        mapper = DBConn.getSession().getMapper(MemberMapper.class);
    }

    RequestJoin getData(){
        Faker faker = new Faker(Locale.ENGLISH);

        RequestJoin form =  RequestJoin.builder()
                    .email(System.currentTimeMillis() + faker.internet().emailAddress())
                    .password(faker.regexify("\\w{8}").toLowerCase())
                    .userName(faker.name().fullName())
                    .termsAgree(true)
                    .build();
        form.setConfirmPassword(form.getPassword());

        return form;
    }

    @Test
    @DisplayName("회원가입 성공시 예외가 발생하지 않음")
    void successTest(){
        RequestJoin form = getData();
        assertDoesNotThrow(()->{
            //JoinService service = new JoinService();
            service.process(form);
        });

        //가입된 이메일로 회원이 조회 되는지 체크 - 조회 테스트
        Member member = mapper.get(form.getEmail());
        assertEquals(form.getEmail(), member.getEmail());
    }

    @Test
    @DisplayName("필수 입력항목(이메일, 비밀번호, 비밀번호 확인, 회원명, 약관동의) 검증, 검증 실패시 예외(BadRequestException) 발생")
    void requiredFieldTest(){
        //예상된 예외가 발생해야 통과
        assertAll(
            //이메일 검증
                ()-> requiredEachFieldTest("email", true, "이메일"),
                ()->requiredEachFieldTest("email", false, "이메일"),
                ()->requiredEachFieldTest("password", false, "비밀번호"),
                ()->requiredEachFieldTest("password", true, "비밀번호"),
                ()->requiredEachFieldTest("confirmPassword", true, "비밀번호를 확인"),
                ()->requiredEachFieldTest("confirmPassword", false, "비밀번호를 확인"),
                ()->requiredEachFieldTest("userName", true, "회원명"),
                ()->requiredEachFieldTest("userName", false, "회원명"),
                ()->requiredEachFieldTest("termsAgree", false, "약관")

        );
    }


    //각 필드값 체크 - 문구도
    void requiredEachFieldTest(String field, boolean isNull, String keyword){
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            RequestJoin form = getData();
            if(field.equals("email")){
                form.setEmail(isNull?null:"   ");
            }else if(field.equals("password")){
                form.setPassword(isNull?null:"   ");
            }else if(field.equals("confirmPassword")){
                form.setConfirmPassword(isNull?null:"   ");
            }else if(field.equals("userName")){
                form.setUserName(isNull?null:"   ");
            }else if(field.equals("termsAgree")){
                form.setTermsAgree(false);            }
            service.process(form);
        }, field + "테스트");

        String message = thrown.getMessage();
        //System.out.println(message); - 오류 메세지
        assertTrue(message.contains(keyword), field + "키워드 테스트");

    }

    @Test
    @DisplayName("비밀번호와 확인이 일치하지 않으면 BadRequestException 발생 -> 발생해야 통과!")
    void passwordMismatchTest(){
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            RequestJoin form = getData();
            form.setConfirmPassword(form.getPassword()+"**");//비밀번호 다르게 설정(테스트용)
            service.process(form);
        });
        String message = thrown.getMessage();
        assertTrue(message.contains("비밀번호가 일치하지"));
    }

    @Test
    @DisplayName("이메일이 형식에 맞지 않으면 BadRequestException 발생")
    void emailPatternTest(){
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            RequestJoin form = getData();
            form.setEmail("wrongtype");
            service.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 형식이"));
    }

    @Test
    @DisplayName("비밀번호 자리수가 8자리 미만이면 BadRequestException 발생")
    void passwordLengthTest(){
        BadRequestException thrown = assertThrows(BadRequestException.class, ()->{
            Faker faker = new Faker();
            RequestJoin form = getData();
            form.setPassword(faker.regexify("\\w{3,7}").toLowerCase());
            form.setConfirmPassword(form.getPassword());
            service.process(form);//8자리 미만으로 예외 발생 예정
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("8자리 이상"));
    }

    @Test
    @DisplayName("이미 가입된 메일인 경우 DuplicatedMemberException 발생")
    void duplicateEmailTest(){
        //회원 중복 테스트 : 이미 가입된 경우 -> join 통과x 하도록
        MemberServiceProvider provider = MemberServiceProvider.getInstance();
        assertThrows(DuplicatedMemberException.class, ()->{
           RequestJoin form = getData();
           provider.joinService().process(form);
           provider.joinService().process(form);
        });
    }
}
