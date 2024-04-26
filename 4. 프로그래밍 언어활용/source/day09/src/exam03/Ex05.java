package exam03;

public class Ex05 {
    public static void main(String[] args) {
        String str = "I like java and javascript";
        boolean matched1 = str.matches("java"); // false
        System.out.println(matched1);

        boolean matched2 = str.matches(".*java.*"); // true
        //boolean matches() -> 패턴 체크 시, 정확한 패턴을 요구한다!
        System.out.println(matched2);

        String str2 = "           ABC              ";
        String str3 = str2.stripLeading(); // 왼쪽 여백 제거
        String str4 = str2.stripTrailing(); // 오른쪽 여백 제거
        System.out.println(str3);
        System.out.println(str4);

        String str5 = str2.stripIndent();
        String str6 = str2.trim();
        System.out.println(str5);
        System.out.println(str6);
    }
}
