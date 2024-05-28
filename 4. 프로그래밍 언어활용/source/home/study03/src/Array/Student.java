package Array;

public class Student {
    String studentId;
    String name;

    public Student(){}

    public Student(String studentId, String name){
        this.studentId = studentId;
        this.name = name;
    }

    public void studentShowInfo(){
        System.out.println(studentId + ',' + name);
    }
}
