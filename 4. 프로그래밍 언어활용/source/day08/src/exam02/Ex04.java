package exam02;

public class Ex04 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);
        //매개변수가 없으면 16byte, 직접 지정할수도 있음 -> 100byte 로 지정!
        sb.append("ABC"); //append() -> StringBuffer에 문자열 추가
        System.out.printf("sb 주소: %d%n", System.identityHashCode(sb));

        sb.append("DEF");
        System.out.printf("sb 주소: %d%n", System.identityHashCode(sb));

        sb.append("GHI");
        System.out.printf("sb 주소: %d%n", System.identityHashCode(sb));

        String str = sb.toString();
        System.out.printf("str 주소: %d%n", System.identityHashCode(str));
        System.out.println(str);
    }
}
