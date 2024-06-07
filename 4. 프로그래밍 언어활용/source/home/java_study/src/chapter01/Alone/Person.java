package chapter01.Alone;

public class Person {
    int age;
    String name;
    boolean isMarried;
    int child;

    public static void main(String[] args) {
        Person james = new Person();
        james.name = "제임스";
        james.age = 40;
        james.isMarried = true;
        james.child = 3;

        System.out.println("나이가 " + james.age + "살, " + "이름이 " + james.name + "라는 남자가 있습니다. " + "이 남자는 결혼을 " + james.isMarried + "자식이 " + james.child + "명 있습니다.");
    }
}
