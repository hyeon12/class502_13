package exam03;

public class Ex04 {
    public static void main(String[] args) {
        String fruits = "Apple, Orange, Mango, Apple";
        //왼쪽에서 오른쪽 이동
        System.out.printf("indexOf Apple : %d%n", fruits.indexOf("Apple"));

        //오른쪽에서 왼쪽 이동
        System.out.printf("lastIndexOf Apple : %d%n", fruits.lastIndexOf("Apple"));

        //없는 경우 -1 반환
        System.out.printf("indexOf Apple : %d%n", fruits.indexOf("Watermelon"));

    }
}
