package exam01;

import java.util.Optional;

public class Ex09 {
    public static void main(String[] args) {
        Book book = null;
        //System.out.println(book.toString()); -> 참조할 값이 없는 경우 NullPointerException 발생
        Optional<Book> opt = Optional.ofNullable(book);

        //Book book2 = opt.orElseGet(() -> new Book()); //없을땐 비어있는 객체 생성~!
        Book book2 = opt.orElseGet(Book::new); //Supplier 형태일때 가능한 메서드참조
        System.out.println(book2);
    }
}
