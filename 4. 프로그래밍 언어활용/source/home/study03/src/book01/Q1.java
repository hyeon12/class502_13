package book01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("a.txt");
            DataOutputStream dos = new DataOutputStream(fos)){
            dos.writeUTF("지금까지 자바 정말 재미있게 공부했어요.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
