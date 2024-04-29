package exam01;

//T는 Fruit의 하위클래스, 충분한 정보가 생겼으므로 Object 아닌, T==Fruit 인식
public class Box<T extends Fruit & Eatable> {
    private T item;

    //private static T item2;
    //정적변수는 사용 불가, 처음부터 공간을 할당 받으므로 자료형이 명확해야 함.


    //private static T[] nums = new T[3];
    //배열 사용 불가, 배열에서 공간 생성을 위해서는 자료형이 명확해야 함.

    public void setItem(T item){
        this.item = item;
    }

    public T getItem(){
        return item;
    }

    public String toString(){
        //T == Object <- 컴파일러가 자료형 Object로 판단해서,
        //item.get() <- 불가능한 상태!

        //T == Fruit 로 인식, get()메서드 사용 가능!
        return item.get();
    }
}
