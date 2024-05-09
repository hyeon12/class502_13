package tostring;

public class Book {
    int bookNumber;
    String bookTitle;

    Book(int bookNumber, String bookTitle){
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString(){
        return bookNumber+","+bookTitle;
    }

    /*
    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                ", BookTitle='" + BookTitle + '\'' +
                '}';
    }
     */
}
