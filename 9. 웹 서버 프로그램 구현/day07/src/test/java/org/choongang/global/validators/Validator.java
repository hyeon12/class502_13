package org.choongang.global.validators;

public interface Validator<T> {
    void check(T form);
    //form 유입 시 검증 => 지네릭타입 : 검증하고자 하는 클래스형
}
