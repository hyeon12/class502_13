package exam01;

public class Ex03 {
    public static void main(String[] args) {
        char ch1 = 'A'; //알파벳 A를 값으로 담음.
        System.out.println(ch1);
        System.out.println(ch1 + 1); //문자=숫자... 연산이 가능함. 문자표!
        System.out.println(ch1 > 'B'); // 비교연산도 가능

        char ch2 = '가';
        System.out.println(ch2);
        System.out.println(ch2 + 1); // 유니코드 '가'로 연산가능
        System.out.println('나' > '가');
    }
}
