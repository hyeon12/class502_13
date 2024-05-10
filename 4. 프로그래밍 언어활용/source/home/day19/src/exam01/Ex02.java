package exam01;


public class Ex02 {
    public static void main(String[] args) {
        double num = 123.12345678;
        System.out.printf("%.3f%n", num);
        //소수점 셋째자리까지
        System.out.printf("%10.2f%n", num);
        //소수점 둘째자리까지 + 소수점포함 총 10칸, 나머지 공백채움
        System.out.printf("%010.2f%n", num);
        //소수점 둘째자리까지 + 공백을 0으로 채움
    }
}
