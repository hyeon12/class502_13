package org.choongang.global.validators;

public interface EmailValidator {
    default boolean checkEmail(String email){
        //계정명@도메인.com|co.kr|org ..
        String pattern = "[^@]+@[^.]+\\.[a-z]+";

        return email.matches(pattern);
    }
}
