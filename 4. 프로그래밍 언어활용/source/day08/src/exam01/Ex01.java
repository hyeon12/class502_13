package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Book b1 = new Book(1000,"책1", "저자1");
        System.out.println(b1); // b1.toString() // Object에 정의된 toString()메서드 호출된 것
    }
}
