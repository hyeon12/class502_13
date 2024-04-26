package exam04;

//Object를 활용해 Box에 Apple과 Grape를 담아보자!
public class Box {
    private Object item;
    //모든 클래스의 상위클래스 Object 로 매개변수나 자료형을 정의?
    //모든 형태의 자료형을 담을 수 있다!

    public Object getItem(){
        return item;
    }

    public void setItem(Object item){
        this.item = item;
    }
}
