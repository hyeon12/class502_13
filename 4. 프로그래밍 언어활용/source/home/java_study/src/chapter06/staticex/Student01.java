package chapter06.staticex;

public class Student01 {
    public static int serialNum = 1000;
    public int studentID;
    public String studentName;
    public int grade;
    public String address;

    public Student01(){
        serialNum++; // 학생이 생성될 때마다 증가
        studentID = serialNum; //증가된 값을 학생ID에 대입 (학번)
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String name){
        this.studentName = name;
    }
}
