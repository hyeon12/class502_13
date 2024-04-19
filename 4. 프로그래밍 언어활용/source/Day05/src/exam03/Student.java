package exam03;

public class Student {
    protected int id;
    protected String name;

    //public Student() { }; 객체를 만들 수단이 없을때만 생성됨!

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}
