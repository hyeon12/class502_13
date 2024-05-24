package exam01;

import configs.DBConn;
import mappers.MemberMapper;
import member.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex01 {
    @Test
    void test1(){
        SqlSession session = DBConn.getSession(); //autoCommit-true 상태
        List< Member> members = session.selectList("mappers.MemberMapper.getList");
        members.forEach(System.out::println);
    }

    @Test
    void test2(){
        SqlSession session = DBConn.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class); //구현체가 내부적으로 만들어짐
        List<Member> members = mapper.getList();
        members.forEach(System.out::println);
    }

    @Test
    void test3(){
        SqlSession session = DBConn.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        List<Member> members = mapper.getList2();
        //인터페이스에 애노테이션으로 수행할 쿼리가 정리되어있음.
        members.forEach(System.out::println);
    }
}
