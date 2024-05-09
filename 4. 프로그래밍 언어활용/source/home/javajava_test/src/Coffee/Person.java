package Coffee;

public class Person {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.printf("%s 씨는 ", name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
