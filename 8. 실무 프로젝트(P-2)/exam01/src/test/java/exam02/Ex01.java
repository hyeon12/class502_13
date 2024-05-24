package exam02;

import configs.DBConn;
import exam01.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex01 {

    @Test
    void test1(){
        SqlSession session = DBConn.getSession(); //가져오면 바로 쿼리수행 가능!
        List< Member> members = session.selectList("mappers.MemberMapper.getList");//DB 조회 완료
        members.forEach(System.out::println);
    }
}
