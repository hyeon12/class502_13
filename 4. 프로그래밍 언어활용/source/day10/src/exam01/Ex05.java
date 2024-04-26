package exam01;

// CLASS 클래스를 매개변수로 넣는 이유?
// 변환작업할 때, 클래스의 정보를 참고하여
// 특정 클래스의 자료형으로 바꿔줘야하기 때문에 사용

public class Ex05 {
    public static void main(String[] args) {
        String tran1 = "BUS";

        //Transportation BUS = Enum.valueOf(Transportation.class, tran1);
        //문자열을 어떤 클래스의 자료형으로 바꿀 건지 참고하기 위해 .Class 필요
        //System.out.println(BUS.name());

        Transportation BUS = Transportation.valueOf(tran1);
        System.out.println(BUS.name());
    }
}
