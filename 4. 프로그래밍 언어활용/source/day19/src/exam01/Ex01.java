package exam01;

public class Ex01 {
    public static void main(String[] args) {
        // %d(정수), %f(실수), %s(문자열), %c(문자1개 char)
        /**
         * %자리수s  -> %5s (총 공간 5, 빈 공백 3칸 공백으로 채워줌) =>ab->공백3칸ab
         * %-자리수s -> %-5s (오른쪽으로 공백) =>ab-ab공백3칸
         */

        System.out.print("----");
        System.out.printf("%10s", "ab");
        System.out.println("----");

        System.out.print("----");
        System.out.printf("%-10s", "ab");
        System.out.println("----");

        System.out.print("-----");
        System.out.printf("%05d", 100); //숫자 채워지고 나머지 0으로채워짐
        System.out.println("-----");
    }
}
