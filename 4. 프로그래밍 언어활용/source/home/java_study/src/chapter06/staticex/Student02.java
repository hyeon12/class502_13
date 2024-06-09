package chapter06.staticex;

public class Student02 {
    private static int serialNum = 1000;
    public int studentID;
    public String studentName;
    public int grade;
    public String address;

    public Student02(){
        serialNum++;
        studentID = serialNum;
    }

    public void setStudentName(String name){
        this.studentName = name;
    }

    public static int getSerialNum(){
        return serialNum;
    }

    public static void setSerialNum(int serialNum){
        Student02.serialNum = serialNum;
    }
}
