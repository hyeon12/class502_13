package exam01;

import java.io.File;
import java.io.IOException;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/fstudy/sub1/sub2/sub3/test1.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        //상대경로가 중간에 포함되어 있는 형태
        //D:/fstudy/test1.txt
        File file2 = new File("D:/fstudy/sub1/sub2/sub3/../../../test1.txt");

        //상대경로 D:\fstudy\sub1\sub2\sub3\..\..\..\test1.txt
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath2);

        //상대경로 -> 절대경로 D:\fstudy\test1.txt
        String canonicalPath = file2.getCanonicalPath();
        System.out.println(canonicalPath);

        //System.out.println("getName() :", file.getName());
        //System.out.println("getPath() :", file.getPath());
    }
}
