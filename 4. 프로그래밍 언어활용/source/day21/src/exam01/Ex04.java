package exam01;

import java.io.*;

public class Ex04 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("score.txt");
            DataInputStream dis = new DataInputStream(fis)){
            int total = 0, cnt = 0;

            try {
                //while(true) -> 무한 반복
                while (true) {
                    int score = dis.readInt();
                    total += score;
                    cnt++;
                }//다 읽으면 예외(EOFExcetpion) 발생
            } catch (EOFException e){//파일을 다 읽은 상태
                System.out.printf("합계: %d, 평균: %.1f", total, (double)total/cnt);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
