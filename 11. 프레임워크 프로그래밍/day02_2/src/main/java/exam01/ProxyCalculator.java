package exam01;

public class ProxyCalculator implements Calculator{

    // ImplCalculator, RecCalculator 대신 수행 하려면? 자료형? -> 다형성 활용

    //private Calculator calculator = new ImplCalculator();
    //ImplCalculator 만 가능하게 됨...

    //개방 폐쇄 원칙 ..
    private Calculator calculator;

    //열린 형태로 정의하여 주입 받은 대로 변형 가능하게!
    public ProxyCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public long factorial(long num) {

        long stime = System.nanoTime(); //공통기능

        try {
            // 다른 계산기의 핵심 기능을 대신 수행 - "대신 수행" 측면에서 Proxy
            long result = calculator.factorial(num);
            //다른 계산기의 factorial 연산을 대신 수행
            return result;
        } finally {
            long etime = System.nanoTime(); //공통기능
            System.out.printf("걸린 시간 : %d%n", etime-stime);
        }
    }
}
