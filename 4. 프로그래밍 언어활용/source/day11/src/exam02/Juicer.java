package exam02;

import java.util.ArrayList;

public class Juicer {//주스만드는기계!

    // ? - Fruit, Apple, Grape (extends - 위에서 아래, 상한 제한)
    public static void make(FruitBox<? extends Fruit> box) {
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
        //사과주스,포도주스 두 종류를 만들고 싶을때!? <>삭제되기 때문에..
        //?-> Object 와 비슷한 역할, 메서드의 매개변수로 쓰임!
    }

    //지네릭 메서드, 제한조건-extends만 사용 가능
    public static <T extends Fruit> void make3(FruitBox<T> box){}

    //? - Apple, Fruit, Object 가능 (super - 아래에서 위, 하한 제한)
    public static void make2(FruitBox<? super Apple> box){
        ArrayList<?> fruits = box.getItems();
        System.out.println(fruits);
    }


    /*
    public static void make(FruitBox<Apple> box){
        //주스 만드는 메서드! - 매개변수에 Apple 넣어 사과주스 만들자!
        ArrayList<Apple> fruits =  box.getItems();
        System.out.println(fruits);
    }

    public static void make(FruitBox<Grape> box){
        //매개변수가 다르면 다른메서드 - Grape 넣어 포도주스!!!!

    }
     */

}
