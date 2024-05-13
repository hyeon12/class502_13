package exam02;

public class DecorateCalculator implements Calculator{

    private Calculator calculator; //내부에서 정의x, 외부에서!
    //private Calculator calculator = new ImpleCalculator();

    public DecorateCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    public long factorial(long num){
        long stime = System.nanoTime(); //공통적인 추가 기능
        try {

            long result = calculator.factorial(num); //핵심기능을 대신 수행
            return result;

        } finally {
            long etime = System.nanoTime(); //공통적인 추가 기능
            System.out.printf("걸린시간: %d%n", etime - stime);
        }
    }
}
