package org.choongang.global.validators;

//기능 공유 인터페이스
public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e){
        if(str==null || str.isBlank()){
            throw e;
        }
    }
}
