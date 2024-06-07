package chapter01;

public class Student01 {
    int studentID;
    String studentName;
    int studentHeight;
    int studentWeight;

    public Student01(int studentID, String studentName, int studentHeight, int studentWeight){
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentHeight = studentHeight;
        this.studentWeight = studentWeight;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "studentID=" + studentID +
                ", studentName='" + studentName +
                ", studentHeight=" + studentHeight +
                ", studentWeight=" + studentWeight +
                '}';
    }
}
