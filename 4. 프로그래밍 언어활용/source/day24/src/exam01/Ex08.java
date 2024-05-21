package exam01;

public class Ex08 {
    public static void main(String[] args) throws InterruptedException{
        Ex08_1 th1 = new Ex08_1("*");
        Ex08_1 th2 = new Ex08_1("**");
        Ex08_1 th3 = new Ex08_1("***");

        th1.start();
        th2.start();
        th3.start();
        //3개 쓰레드 시작

        Thread.sleep(2000);
        th1.suspend(); //2초 후 th1 일시정지

        Thread.sleep(2000);
        th2.suspend(); //2초 후 th2 일시정지

        Thread.sleep(3000); //3초 후
        th1.stop(); //정지(종료)
        th2.stop(); //정지(종료)

        Thread.sleep(2000);
        th3.stop(); //정지(종료)
    }
}

class Ex08_1 implements Runnable{

    //통제할 수 있는 값을 가지고, 메서드 통제
    private volatile boolean  stopped = false; // 정지x - true이면 멈춘 상태
    private volatile boolean suspended = false; // 일시정지x - true이면 정지상태

    private Thread th;

    public Ex08_1(String name){ //내부에 만들고 기능 통제
        th = new Thread(this, name);
        //this - Runnable 인터페이스 구현객체, 내부에서 쓰레드 객체를 만들어 통제
        //name - 쓰레드 이름
    }

    @Override
    public void run() {//실행하고자 하는 메서드
        while(!stopped){
            if(!suspended){
                System.out.println(th.getName());
                try{
                Thread.sleep(1000); //대기시간없이 넘어가므로, 사용성 증대
                } catch (InterruptedException e){
                    System.out.println("interrupted");
                };
            } else { // 일시 정지 상태 -> 다른 쓰레드로 바로 작업 양보
                th.yield();
            }
        }
    }

    //내부에서 객체 생성 후, 메서드 정의
    public void start(){
        th.start();
    }

    public void suspend(){
        suspended = true;
        System.out.println("suspend - interrupted");
    }

    public void resume(){
        suspended = false;
    }

    public void stop(){
        stopped = true;
        System.out.println("stop - interrupted");
    }
}
