package exam03;

public class Box <T>{

    private T item;

    //Box가 객체가 될 때 T의 자료형이 결정 -> 지네릭 클래스의 T
    public void method1(T str1, T str2) {

    }

    //지네릭메서드 - 함수 호출 시에 T의 자료형 결정 -> 지네릭 메서드의 T
    public <T> void method2(T str1, T str2){

    }

    //method1의 T와 method2의 T는 다르다! 자료형 다름!!!
}
