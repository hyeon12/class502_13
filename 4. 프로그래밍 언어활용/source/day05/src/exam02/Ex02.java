package exam02;

public class Ex02 {
    public static void main(String[] args) {
       C c = new C();
       A a = c; //a에 "c라는 객체의 내용물"을 담은 것.. 출처 = c
       B b = c;

        //A a = new C();

        System.out.println("a: " + System.identityHashCode(a));
        System.out.println("b: " + System.identityHashCode(b));
        System.out.println("c: " + System.identityHashCode(c));


    }
}
