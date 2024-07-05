package exam01;

public class Greeter {
    //스프링 컨테이너 관리 객체
    public void hello(String name){
        //이름이 들어가면 "ㅇㅇ님 안녕하세요" 메세지 출력
        System.out.printf("%s님 안녕하세요.", name);
    }
}
