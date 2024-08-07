package exam01;

import java.io.File;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:/fstudy/sub1/sub2/sub3");
        File file = new File(dir, "test1.txt");

        if(!dir.exists()){
            dir.mkdirs(); // -하위폴더도 재귀적으로 모두 생성(s)
        }

        file.createNewFile();

        //is가 붙어있으면 ~인지, 아닌지?
        System.out.println("dir 디렉토리 ? " + dir.isDirectory());
        System.out.println("dir 파일 ? " + dir.isFile());
    }
}
