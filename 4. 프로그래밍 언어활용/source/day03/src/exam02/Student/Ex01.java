package exam02.Student;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이이름", "자바");
        Student s2 = new Student(1001, "김이름", "리액트");

        System.out.println("s1:" + s1); // s1.id = 1000
        System.out.println("s2:" + s2); // s2.id = 1001
        // 같은 주소값이므로, 마지막에 대입한 값으로 적용됨.

        System.out.println(s1.id); // Student.id 클래스명 입력 권장
        System.out.println(s2.id); // Student.id

        s1.instanceMethod(); //객체가 있어야만 사용 가능
    }
}
