package exam06;

public class Book {
    private int isbn; //도서번호
    private String title; //도서제목
    private String author; //도서저자

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author; // 값 초기화 -> 값을 확인해볼 수 있는 형태로 to.String()을 재정의한다!
    }

    @Override
    public String toString() {
        return String.format("isbn=%d, title=%s, author=%s%n", isbn, title, author);
    }
}
