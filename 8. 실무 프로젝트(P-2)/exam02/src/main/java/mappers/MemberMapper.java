package mappers;

import member.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {
    List<Member> getList();

    @Select("SELECT USER_NO userNo, USER_ID userId FROM MEMBER")
    List<Member> getList2();

    List<Member> getList3(Member member);

    List<Member> getList4(List<String> userIds);

    List<Member> getList5(long userNo);

    int register(Member member); //투입된 값을 가지고 쿼리 수행되어 값 입력
    int register2(Member member);

    int modify(Member member);

    int delete(String userId); //매개변수=변수명 동일해야 매핑!

    @Delete("DELETE FROM MEMBER WHERE USER_ID=#{userId}")
    int delete2(String userId);
}
