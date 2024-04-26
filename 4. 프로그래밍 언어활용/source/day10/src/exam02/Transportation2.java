package exam02;

//열거형의 내부 형태
public abstract class Transportation2 /*extends java.lang.Enum*/ {
    public static final Transportation2 BUS = new Transportation2(){
        public int getTotal(int person){return 0;}
    };
    public static final Transportation2 SUBWAY = new Transportation2(){};
    public static final Transportation2 TAXI = new Transportation2(){};
    //상수만 열거하더라도, 위와 같은 형태가 클래스 내부에 자동추가된 형태로 정의됨!
    //정적상수 -> 객체인 이유... 변수,함수에 접근하기 위해서!(2번째 비밀!)

    //abstract 추상클래스 ... 미구현된 메서드 정의

    private Transportation2(){}
    //외부통제제한!(상수니까) + 통제가능한 부분만 get,set 정의(3번째 비밀!)

    //public abstract int getTotal(int person); //구현체가 있어야함.

}
