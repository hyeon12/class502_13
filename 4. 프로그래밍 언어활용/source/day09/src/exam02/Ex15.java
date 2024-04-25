package exam02;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Ex15 {
    public static void main(String[] args) {
        String str = "Apple Mange       Melon Banana";
        String[] fruits = str.split("\\s+");
        System.out.println(Arrays.toString(fruits));
    }


}
