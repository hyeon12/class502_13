package student;

public class Student {
    private static int studentId;
    private int cardNum;
    String name;

    public Student(String name){
        this.name = name;
        this.cardNum = (studentId++) + 100;
    }

    public String toString(){
        return String.format("학생이름: %s, 학번: %d, 학생 카드 번호: %d%n", name, studentId, cardNum);
    }

}
