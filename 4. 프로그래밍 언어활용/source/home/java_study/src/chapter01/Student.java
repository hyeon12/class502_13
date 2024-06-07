package chapter01;

public class Student {
    int studentID;
    String studentName;
    int grade;
    String address;

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String name){
        studentName = name;
    }

    public static void main(String[] args) {
        Student studentSeo = new Student();
        studentSeo.setStudentName("서정현");

        System.out.println(studentSeo.studentName);
        System.out.println(studentSeo.getStudentName());
    }
}
