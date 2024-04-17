package exam03;

public class Board {

    private static Board instance = new Board(); //(2)클래스 내부에서 객체 생성

    private Board(){} //(1)접근제어자 private - 외부에서의 접근 통제

    public static Board getInstance() {
        return instance; //(3)객체를 반환하는 함수 정의
    }
}
