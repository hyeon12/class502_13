package exam01;

import config.AppCtx;
import mappers.member.MemberMapper;
import member.entities.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@Transactional //테스트 -> 자동 롤백! (DB에 저장X)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex03 {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    void test1(){
        System.out.println(memberMapper);
        //org.apache.ibatis.binding.MapperProxy@1d035be3
        //MemberMapper 인터페이스 -> 매퍼 프록시 객체 생성됨
    }

    @Test
    void test2(){
        long total = memberMapper.getTotal();
        System.out.println(total);
    }

    @DisplayName("쿼리문 테스트")
    @Test
    void test3(){
        Member member = Member.builder()
                .email("user06@test.org")
                .password("12345678")
                .userName("사용자06")
                .build();

        System.out.println("register 테스트");
        int result = memberMapper.register(member);
        System.out.println(result);

        System.out.println("get 테스트");
        Member member2 = memberMapper.get(member.getEmail());
        System.out.println(member2);

        System.out.println("exists 테스트");
        int exists = memberMapper.exists(member.getEmail());
        System.out.println(exists);
    }
}
