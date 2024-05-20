package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Ex01_1 th = new Ex01_1();
        th.start();
        //th.run();

        for(int i = 0; i < 5; i++){
            System.out.println("메인 쓰레드 - " + i);
        }
    }
}

//쓰레드 정의방법 (1)Thread 클래스 상속, run 메서드를 재정의
class Ex01_1 extends Thread {
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(getName() + " - " + i);
        }
    }
}
