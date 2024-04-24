package exam03;

//Class 클래스 예제
public class Person {
    public int age;
    public String name;

    public Person() {}
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
}
