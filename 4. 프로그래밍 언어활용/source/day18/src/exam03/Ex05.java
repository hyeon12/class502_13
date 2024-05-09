package exam03;

import java.awt.*;
import java.text.ChoiceFormat;

public class Ex05 {
    public static void main(String[] args) {
        double[] limits = {60, 70, 80, 90};
        //60~70=D / 70~80=C / 80~90=B / 90~ =A
        //String[] grades = {"D", "C", "B", "A"};
        //ChoiceFormat cf = new ChoiceFormat(limits, grades);
        String pattern = "60#D|70#C|80<B|90#A";
        ChoiceFormat cf = new ChoiceFormat(pattern);

        int[] scores = {100, 70, 55, 80, 96, 87};
        for(int score : scores){
            String grade = cf.format(score);
            System.out.printf("점수: %d, 학점: %s%n", score, grade);
        }
    }
}
