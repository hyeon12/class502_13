package exam01;

import configs.DBConn;
import mappers.MemberMapper;
import member.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class Ex02 {

    private SqlSession session = DBConn.getSession();

    @Test
    void test1(){//INSERT
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        Member member = Member.builder()
                .userId("USER" + System.currentTimeMillis())
                .userPw("123456")
                .userNm("사용자..")
                .mobile("01000000000")
                .build(); //빌더 패턴으로 값 넣기
        //int cnt = mapper.register(member); //id와 동일한 이름으로 추상메서드 정의
        int cnt = mapper.register2(member);
        //int cnt = session.insert("mappers.MemberMapper.register", member);
        System.out.println(cnt);
        System.out.println(member);
    }

    @Test
    void test2(){//UPDATE
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        Member member = Member.builder()
                .userId("USER01")
                .userPw("123456")
                .userNm("(수정)사용자01(변경)")
                .mobile("01000000000")
                .build();
        //int cnt = session.update("mappers.MemberMapper.modify", member);
        int cnt = mapper.modify(member);//인터페이스에 추상메서드 정의하여 간단하게 쓸 수 있다!
        System.out.println(cnt);
    }

    @Test
    void test3(){ //DELETE
        Member member = Member.builder()
                .userId("USER01")
                .build();

        int cnt = session.delete("mappers.MemberMapper.delete", member);
        System.out.println(cnt);
    }

    @Test
    void test4(){
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        int cnt = mapper.delete("USER02");
        int cnt2 = mapper.delete2("USER03");
        System.out.println(cnt);
        System.out.println(cnt2);
    }
}
