package exam01;

import javax.swing.*;

public class Ex06 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Runnable r = () -> {}; //4byte 공간할당
        Thread th = new Thread(r);
        아래와 같이 람다식 정의
        */
        Thread th = new Thread(() -> {
            String message = JOptionPane.showInputDialog("메세지 입력");
            System.out.println(message);
        });

        th.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

            Thread.sleep(1000); //쓰레드의 실행 시간지연(1초)
        }
    }
}
