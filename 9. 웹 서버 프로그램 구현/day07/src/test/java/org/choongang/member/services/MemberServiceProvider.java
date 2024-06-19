package org.choongang.member.services;

import org.choongang.member.validators.JoinValidator;

// 회원쪽 기능을 제공하는 provider
// 객체 조립기
public class MemberServiceProvider {
    //싱글톤패턴 - 객체조립기=기능적인 내용으로 객체 만들 필요 없으므로!
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {}

    public static MemberServiceProvider getInstance() {
        if (instance == null) {
            instance = new MemberServiceProvider();
        }

        return instance;
    }

    // ▽ 객체 조립할 재료 ▽
    public JoinValidator joinValidator(){
        return new JoinValidator();
        //회원가입 검증 validator
    }

    public JoinService joinService(){
        return new JoinService(joinValidator());
    }
}
