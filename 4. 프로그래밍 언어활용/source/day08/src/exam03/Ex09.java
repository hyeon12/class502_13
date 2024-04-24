package exam03;

public class Ex09 {
    public static void main(String[] args) throws ClassNotFoundException{
        //중간에 Person 클래스를 제공받았다는 가정하에 동적로딩하기
        Class cls = Class.forName("exam03.Person");
    }
}
