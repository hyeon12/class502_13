package 다른패키지;

import 같은패키지.A;

public class B extends A { //protected-상속받은 클래스내에서 정의가능
    void print(){
        protectedNum = 100;
        System.out.println(protectedNum);
    }
}
