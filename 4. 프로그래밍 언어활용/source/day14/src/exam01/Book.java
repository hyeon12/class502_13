package exam01;

import java.util.function.Supplier;

public class Book {//참조변수::메서드명 예시를 위한 클래스
    private String title;

    public String getTitle(){
        return title;
    }

    public void printTitle(){
        Supplier<String> t1 = () -> getTitle();
        Supplier<String> t2 = this::getTitle; //참조변수로 메서드 참조 가능
    }
}
