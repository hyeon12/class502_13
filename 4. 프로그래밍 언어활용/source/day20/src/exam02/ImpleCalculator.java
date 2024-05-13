package exam02;

//성능 좋은 for문 형태로 정의
public class ImpleCalculator implements Calculator{

    @Override
    public long factorial(long num) {
        long total = 1L;
        for(long i = 1; i <= num; i++){
            total *= i;
        }
        return total;
    }
}
