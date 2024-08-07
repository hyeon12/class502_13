package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;

// 회원쪽 기능을 제공하는 provider
// 객체 조립기
public class MemberServiceProvider {
    //싱글톤패턴 -> 객체조립기=기능적인 내용으로 객체 만들 필요 없으므로!
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {}

    public static MemberServiceProvider getInstance() {
        if (instance == null) {
            instance = new MemberServiceProvider();
        }

        return instance;
    }

    // ▽ 객체 조립할 재료 - 각 객체의 의존성이 추가될 때마다 추가하면 됨! ▽

    public SqlSession getSession(){
        return DBConn.getSession(); //session
    }

    public MemberMapper memberMapper(){
        return getSession().getMapper(MemberMapper.class);
    }

    public JoinValidator joinValidator(){
        return new JoinValidator(memberMapper());
        //회원가입 검증 validator
    }

    public JoinService joinService(){
        return new JoinService(joinValidator(), memberMapper());
    }

    public LoginValidator loginValidator(){
        return new LoginValidator(memberMapper());
    }

    public LoginService loginService(){
        return new LoginService(loginValidator(), memberMapper());
    }
}
