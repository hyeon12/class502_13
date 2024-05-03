package exam01;

import java.util.Optional;

public class Ex08 {
    public static void main(String[] args) {
        String str = "ABC";
        Optional<String> opt = Optional.of(str);
        System.out.println(opt);
        System.out.println(opt.get());

        String str2 = null;
        //Optional<String> opt2 = Optional.of(str2); - Optional.of 는 null 허용x
        Optional<String> opt2 = Optional.ofNullable(str2);
        System.out.println(opt2);
        //System.out.println(opt2.get()); - null이면 noSuchElementException 발생
        String value = opt2.orElse("기본값");
        System.out.println(value);
    }
}
