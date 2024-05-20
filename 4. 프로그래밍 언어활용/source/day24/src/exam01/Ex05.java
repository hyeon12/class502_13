package exam01;

public class Ex05 {

    private static boolean autoSave = false;

    public static void main(String[] args){
        Thread th = new Thread(()-> {
            while(true){ //무한 루프... 계속 "저장" 반복 -> 쓰레드가 모두 종료되어야 끝남
                try {
                    Thread.sleep(3000); //3초
                } catch (InterruptedException e){}

                if(autoSave){
                    System.out.println("저장!");
                }
            }
        });

        th.setDaemon(true);
        //쓰레드 실행
        th.start();

        //메인쓰레드 실행
        for(int i = 1; i <= 10; i++){
            Thread th2 = Thread.currentThread();
            System.out.println(th2.getName() + " - " + i);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){}

            if (i == 3) autoSave = true;
        }
    }
}
