package global.validators;

public interface RequiredValidator {
    default void checkRequired(String field, RuntimeException e){
    //다양한 예외 상황에 대비하기 위해 RuntimeException
        if(field == null || field.isBlank()){
            throw e;
        }
    }

    default void checkTrue(boolean result,RuntimeException e){
        if(!result){
            throw e;
        }
    }
}
