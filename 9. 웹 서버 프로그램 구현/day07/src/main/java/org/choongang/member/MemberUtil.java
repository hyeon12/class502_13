package org.choongang.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.choongang.member.entities.Member;

public class MemberUtil {
    //로그인 여부 체크 메서드
    public static boolean isLogin(HttpServletRequest request){
        //Member member = getMember(request); - 반환값만 필요하므로 바로 쓰기
        return getMember(request) != null;
    }

    //회원정보 가져올 수 있는 메서드
    public static Member getMember(HttpServletRequest request){
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        return member;
    }
}
