package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Transportation trans = Transportation.TAXI;
        String str = trans.name(); //trans.toString()
        // 문자열로 바꿀 때 name() 사용!
        System.out.println(str);

        int ordinal = trans.ordinal();
        // TAXI의 ordinal() 값 -> 상수위치번호[열거형에서의 위치]
        System.out.println(ordinal);

    }
}
