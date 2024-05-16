package exam02;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt")){
            byte[] buffer = new byte[5]; //더 큰 단위도 가능하나, 5줄로 설정!
            while(fis.available() > 0){
                int ch = fis.read(buffer);//buffer에 데이터가 담김!
                //ch -> 읽어온 바이트 수
                //System.out.println(ch);
                for(int i = 0; i< ch; i++){
                    System.out.print((char)buffer[i]);
                }
                System.out.println();
            }
            //BufferedOutputStream
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
