package exam02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //터미널쪽에서 입력할 수 있는 scanner 객체 생성!
        //System.out.print("숫자를 포함하여 입력:");
        System.out.println("숫자만 입력:");
        String str = sc.nextLine();

        //숫자포함하여 입력하도록 패턴 객체 생성
        //Pattern p1 = Pattern.compile("[0-9]"); //메타문자 -
        //Pattern p1 = Pattern.compile("\\d"); // \d -> \\d (\하나만 입력하면 제거됨)
        //Pattern p1 = Pattern.compile("[^0-9]");//부정문자 : 숫자가 아닌 문자
        Pattern p1 = Pattern.compile("\\D");//숫자가 아닌 문자 \\D->\D

        Matcher m1 = p1.matcher(str);
        if(m1.find()){
            System.out.println("숫자만 입력하세요.");
        }

        /*
        if(!m1.find()){

            System.out.println("숫자를 포함하여 입력하세요.");
        }
        */
    }
}
