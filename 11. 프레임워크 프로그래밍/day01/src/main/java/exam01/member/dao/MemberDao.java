package exam01.member.dao;

import exam01.member.entities.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DAO(Data Access Object)
@Component
public class MemberDao { // 빈 이름 - memberDao

    private static Map<String, Member> members = new HashMap<>();

    //가입시 등록
    public void register(Member member){
        members.put(member.getEmail(), member);
    }

    //조회
    public Member get(String email){
        return members.get(email);
    }

    public List<Member> getList(){
        List<Member> data = new ArrayList<>(members.values());
        return data;
    }

}
