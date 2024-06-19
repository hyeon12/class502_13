package org.choongang.global.validators;

public interface Validator<T> {
    void check(T form);
    //form 유입 시 검증
}
