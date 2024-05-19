package book01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Q1_1 {
    public static void main(String[] args) {
        String txt = "지금까지 자바 정말 재미있게 공부했어요.";
        try(FileOutputStream fos = new FileOutputStream("a1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos)){
            osw.write(txt);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
