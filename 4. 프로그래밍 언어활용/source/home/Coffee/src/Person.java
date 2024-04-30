public class Person {
    String name;

    public Person(String name){
        this.name = name;
        System.out.printf("%s가 ", name);
    }

    public void buy(){
        System.out.printf("%s가 ", name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
