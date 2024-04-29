package exam04;

public class Book {
    private int isbn; //도서번호
    private String title; //도서명
    private String author; //저자

    public Book(int isbn, String title, String author) {//생성자로 초기화
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() { //toString() 재정의로, 내부값 확인할 수 있게 됨.
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
