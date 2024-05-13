package exam01;

import java.io.*;
import java.nio.Buffer;

public class Ex07 {
    public static void main(String[] args) {
        long stime = System.currentTimeMillis();//작업 시작 시간

        try(FileInputStream fis = new FileInputStream("specs.zip");
            BufferedInputStream bis = new BufferedInputStream(fis); //8kb 배열
            FileOutputStream fos = new FileOutputStream("specs_copied2.zip");
            BufferedOutputStream bos = new BufferedOutputStream(fos)){

            while(bis.available() > 0){
                bos.write(bis.read());//8kb 꽉 차면 출력 -> 비우기 -> 출력
                //마지막 8kb 다 차지 않을수도 있음
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long etime = System.currentTimeMillis(); // 작업 끝난 시간
        System.out.printf("걸린 시간: %d%n", etime - stime);
    }
}
