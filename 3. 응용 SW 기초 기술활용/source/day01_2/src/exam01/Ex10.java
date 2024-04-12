package exam01;

public class Ex10 {
    public static void main(String[] args) {
        int num1 = 10000000;
        byte num2 = (byte)num1; // 명시적 형변환 / 강제 형변환
        System.out.println(num2);

        int num3 = 100;
        byte num4 = (byte)num3; //데이터 유실이 없어도 자료형(큰->작) 변환의 경우,
        System.out.println(num4); // 명시적 형변환
    }
}
