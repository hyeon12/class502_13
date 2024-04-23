package exam01;

public class Ex04 {
    public static void main(String[] args) {
        A a = new A() {
            public void method(){
                System.out.println("재정의된 메서드!");
            }
        }; //생성과정에서 메서드의 재정의 할 수 있다!

        a.method();
    }
}
