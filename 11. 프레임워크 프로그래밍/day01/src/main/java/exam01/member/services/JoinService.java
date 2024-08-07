package exam01.member.services;

import exam01.member.controllers.RequestJoin;
import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import exam01.member.validators.JoinValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class JoinService {

    //구성 - 다른객체를 멤버 변수로 포함하여, 기능 확장/조합하는 디자인 패턴
//    @Autowired
//    private JoinValidator validator;
//    @Autowired
//    private MemberDao memberDao;

    private final JoinValidator validator;
    @NonNull
    private MemberDao memberDao;

//    //의존 관계 (의존객체 필수, 없으면 객체 생성 X)
//    public JoinService(JoinValidator validator, MemberDao memberDao){
//        this.validator = validator;
//        this.memberDao = memberDao;
//    }

    //   연관 관계 (의존객체 없어도 객체생성 가능)
//    public void setValidator(JoinValidator validator){
//        this.validator = validator;
//    }

    //회원가입 서비스를 처리하기 위해 필요한 객체 = 의존객체
    public void process(RequestJoin form){
        validator.check(form);
        // joinService는 validator 객체, form 객체를 의존 -> "의존성"

        // 검증 통과 -> 데이터 영구 저장 : DAO(Data Access Object)
        Member member = Member.builder()
                        .email(form.getEmail())
                        .password(form.getPassword())
                        .userName(form.getUserName())
                        .regDt(LocalDateTime.now())
                        .build();

        memberDao.register(member);
    }
}
