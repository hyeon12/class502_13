package exam02;

public class Company {
    //private static Company instance = new Company();

    private static Company instance;
    //싱글톤 패턴을 구현하는 클래스의 유일한 인스턴스를 참조하기 위해
    //자료형 Company 로 instance

    private Company(){}//private-클래스 내에서 접근 가능

    public static Company getInstance(){
        //내부에서 만든 객체를 사용하는 메서드
        if(instance == null){
            instance = new Company();
        }
        return instance;
    }


}
