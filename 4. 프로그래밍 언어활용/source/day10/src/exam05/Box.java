package exam05;

public class Box<T> {
    private T item; //자료형 T

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

