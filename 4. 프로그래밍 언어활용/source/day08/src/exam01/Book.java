package exam01;

//import java.lang.*; - 자동추가

import java.util.Objects;

public class Book extends java.lang.Object {//데이터를 담을 수 있는 데이터 클래스
    private int isbn;
    private String title;
    private String author;

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj); 기본 Object의 equal : 동일성비교
        //vv 동등성 비교를 위해 메서드를 재정의 할 것!vv
        if(obj instanceof Book){
            Book book = (Book)obj;
            if(isbn == book.isbn && title.equals(book.title) && author.equals(book.author)) {
            return true;}
            }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author);
    }

    @Override
    public String toString() { //값을 확인해볼 수 있는 패턴으로!
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
