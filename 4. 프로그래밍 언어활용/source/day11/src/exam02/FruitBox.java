package exam02;

import java.util.ArrayList;

public class FruitBox<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void add(T fruit){
        items.add(fruit); // 많은 과일을 담기 위한 메서드 정의!
    }

    public ArrayList<T> getItems(){
        return items; //담겨있는 과일을 반환하는 메서드!
    }
}
