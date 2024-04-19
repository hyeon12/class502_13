package exam02;

public class Ex03 {
    public static void main(String[] args) {
        C c  = new C(); // c라는 참조변수에 객체 C의 주소값이 담겨있음
        System.out.println(c instanceof C);// c가 가리키는 객체의 출처가 C인가?
        System.out.println(c instanceof B);
        System.out.println(c instanceof A);
        //모두 true -> C객체에 A,B가 모두 포함되어있기 때문

    }
}
