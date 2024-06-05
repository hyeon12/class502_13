package global.validators;

/**검증에 대한 "틀"
 * 검증하려는 전달용객체가 RequestJoin이 될수도,
 * RequestLogin이 될 수도 있으므로 지네릭스를 사용한다!
 */
public interface Validator<T> {
    void check(T form);
}
