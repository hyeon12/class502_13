package chapter01;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.studentName = "서정현";
        Student student2 = new Student();
        student2.studentName = "서정인";
        System.out.println(student1.studentName);
        System.out.println(student2.studentName);

        //생성된 참조변수는 각각 다른 주소
        System.out.println(student1);
        System.out.println(student2);

        Student01 s1 = new Student01(2014, "서학생", 153, 50);
        System.out.println(s1);

        Student02 s2 = new Student02();
        s2.setStudentName("박학생");
        System.out.println(s2.getStudentName());
    }
}
