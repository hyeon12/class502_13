package exam02;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("a.txt")){
            //AutoCloseable auto = fis; -> 정의하지 않아도 내부적으로 동작한다!

        }   catch(IOException e) {
            e.printStackTrace();
        }
    }
}
