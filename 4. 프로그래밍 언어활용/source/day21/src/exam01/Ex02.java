package exam01;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("test1.txt");
            DataInputStream dis = new DataInputStream(fis)){

            byte num = dis.readByte();
            char ch = dis.readChar();
            String str = dis.readUTF();
            //작성한 순서 그대로 써야하며, 순서가 바뀌게 되면 데이터를 정확하게 읽지x


            System.out.printf("num=%d, ch=%c, str=%s%n", num, ch, str);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
