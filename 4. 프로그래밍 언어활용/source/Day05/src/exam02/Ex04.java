package exam02;

import java.sql.SQLOutput;

public class Ex04 {
    public static void main(String[] args) {
        A ad = new D(); //D가 출처인 A
        A ac = new C(); //C가 출처인 A

        //System.out.println(ad.numA);
        //System.out.println(ac.numA);

        if(ad instanceof C) { //false
            C c = (C) ad;// 출처가 다를 수 있어 문제가 될 수 있다...!->자료형체크필요
        }

        if(ac instanceof C){
            C cc = (C) ac; //강제형변환
            System.out.println(cc.numA);
        }
    }
}
