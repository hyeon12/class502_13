package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Thread th = new Thread(new Ex02_1());
        th.start();

        for(int i = 0; i < 5; i++){
            System.out.println("메인 쓰레드 -" + i);
        }
    }
}

//(2)Runnable 인터페이스 구현 → Thread 객체 생성시 생성자 매개변수로 설정
class Ex02_1 implements Runnable{

    @Override
    public void run() {
        //실행중인 쓰레드 객체
        Thread th = Thread.currentThread();
        for(int i = 0; i < 5; i++){
            System.out.println(th.getName() + " - " + i);
        }
    }
}
