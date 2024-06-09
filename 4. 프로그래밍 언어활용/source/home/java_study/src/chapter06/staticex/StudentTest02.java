package chapter06.staticex;

public class StudentTest02 {
    public static void main(String[] args) {
        Student02 s1 = new Student02();
        s1.setStudentName("김이름");
        System.out.println(Student02.getSerialNum());
        System.out.println(s1.studentName + " 학번은 " + s1.studentID);

        Student02 s2 = new Student02();
        s2.setStudentName("남이름");
        System.out.println(Student02.getSerialNum());
        System.out.println(s2.studentName + " 학번은 " + s2.studentID);
    }
}
