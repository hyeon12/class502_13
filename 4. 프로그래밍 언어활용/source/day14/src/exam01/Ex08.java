package exam01;

import java.util.function.Supplier;

public class Ex08 {
    public static void main(String[] args) {
        Supplier<Book> s1 = () -> new Book();
        Supplier<Book> s2 = Book::new; //Book 객체 생성

        Book b1 = s2.get(); //Supplier.get() - 결과호출
        System.out.println(b1);
    }
}
