package chapter06.staticex;

public class StudentTest01 {
    public static void main(String[] args) {
        Student01 s1 = new Student01();
        s1.setStudentName("김스타");
        System.out.println(s1.serialNum);
        System.out.println(s1.studentName + "의 학번 : " + s1.studentID);

        Student01 s2 = new Student01();
        s2.setStudentName("햄벅스");
        System.out.println(s2.serialNum);
        System.out.println(s2.studentName + "의 학번 : " + s2.studentID );
    }
}
