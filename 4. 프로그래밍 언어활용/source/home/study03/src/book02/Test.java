package book02;

public class Test {
    public static void main(String[] args) {
        Calculator cal = (a, b) -> a+b;
        System.out.println(cal.add(1, 2));
    }
}
