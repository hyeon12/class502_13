package exam03;

import java.security.MessageDigest;
import java.text.MessageFormat;

//데이터 -> 형식화된 문자열
public class Ex06 {
    public static void main(String[] args) {
        String pattern = "이름:{0}, 전화번호:{1}";
        //0,1 -> 바꿀 위치 / 입력하면 순서대로 데이터 채워짐

        String[] names = {"이이름", "김이름", "최이름"};
        String[] mobiles = {"010-1111-1111", "010-2222-2222", "010-3333-3333"};

        for(int i = 0; i < names.length; i++){
            String str = MessageFormat.format(pattern, names[i], mobiles[i]);
            System.out.println(str);
        }
    }
}
