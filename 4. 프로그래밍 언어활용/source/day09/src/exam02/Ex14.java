package exam02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex14 {
    public static void main(String[] args) {
        String str1 = "https://www.naver.com";
        String str2 = "ftp://www.naver.com";
        //https, ftp 가져오고 싶을때!(:앞에 있는 단어 전방탐색패턴으로 가져오기)
        Pattern p1 = Pattern.compile("\\w*(?=:)");
        //전방탐색 (?=패턴) ?=: -> : 앞의 범위 가져오기
        Matcher m1 = p1.matcher(str1);
        if(m1.find()){
            System.out.println(m1.group());
        }
    }
}
