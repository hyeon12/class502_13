package exam03;

public class Ex10 {
    public static void main(String[] args) {
        Person p = new Person();
        Class c = p.getClass(); //Person Class 클래스를 선언
        System.out.println(c); // 클래스 정보

        Class c1 = Person.class;
        System.out.println(c1);

        //Class c2 = Class.forName("java.lang.Person");
        //System.out.println(c2);
    }

}
