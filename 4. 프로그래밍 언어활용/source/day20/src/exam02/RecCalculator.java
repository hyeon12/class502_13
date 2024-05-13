package exam02;

public class RecCalculator implements Calculator{

    @Override
    public long factorial(long num) {
        if(num < 1L){
            return 1L;
        }
        return num * factorial(num - 1);
        //재귀방식 -> 호출할때마다 스택메모리 사용하므로 성능 저하
    }
}
