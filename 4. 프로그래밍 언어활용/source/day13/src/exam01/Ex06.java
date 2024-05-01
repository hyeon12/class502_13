package exam01;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        String[] fruits1 = {"apple", "orange", "mango", "melon"};
        String[] fruits2 = {"apple", "orange", "banana", "grape"};

        int pos = Arrays.mismatch(fruits1, fruits2); //동일한경우 -1
        System.out.println(pos);
    }
}
