package exam02;

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = (a, b) -> a + b;

        /*int c = 10; //외부에 있는 지역변수가 사라지지 않게 하기 위해 .. 지역변수의 상수화!
        Calculator cal = (a, b) -> {
           //c = 20; -> 위의 지역변수 상수화로 값이 바뀌지 않음!
            return a + b + c;
        };
        int result = cal.add(10, 20);
        System.out.println(result);*/
    }
}
