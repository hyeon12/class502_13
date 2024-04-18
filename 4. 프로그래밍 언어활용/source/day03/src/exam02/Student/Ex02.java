package exam02.Student;

public class Ex02 {
    public static void main(String[] args) {
        Student.id = 10;
        System.out.println(Student.id); //객체와 상관없이 쓸 수 있는 변수(static 키워드)

        Student.staticMethod();
    }
}
