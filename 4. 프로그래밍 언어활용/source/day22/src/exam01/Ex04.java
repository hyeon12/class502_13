package exam01;

import java.io.File;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        //File file = new File("D:/test1.txt");
        //file.createNewFile(); //비어있는 파일 생성
        //IOException이 발생하므로, throws!

        File dir = new File("D:/fstudy");
        File file = new File(dir, "test1.txt");

        //exists() : 파일 또는 디렉토리 존재 유무 확인
        if (!dir.exists()){
            dir.mkdir(); // 디렉토리 1개만 생성
        }

        file.createNewFile();

    }
}
