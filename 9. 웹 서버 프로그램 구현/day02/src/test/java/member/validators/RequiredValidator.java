package member.validators;

//인터페이스에 각 기능 구현하여, 필요에 따라 추가/삭제
public interface RequiredValidator {
    //편의기능 중 필수 항목 검증
    default void checkRequired(String str, RuntimeException e){
        if(str == null || str.isBlank()){
            throw e;
        }
    }
}
