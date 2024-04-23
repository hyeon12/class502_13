package exam06;

public class Ex01 {
    public static void main(String[] args) {
        Book book = new Book(1000, "책1", "저자1");
        System.out.println(book); // book->book.toString();참조변수에 자동 추가
        Class cls = Book.class; //class 클래스 -> class의 구성정보가 담긴 클래스
        Class cls2 = book.getClass();
        System.out.println(cls);
    }
}
