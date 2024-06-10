package global.validators;

public interface Validator<T> {
    //입력받는 데이터를 검증할 설계틀 - 다양한 자료형을 수용하기 위해 지네릭스
    void check(T form);
}
