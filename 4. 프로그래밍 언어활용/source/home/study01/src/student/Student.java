package student;

public class Student {
    private static int studentId;
    private int _studentId;
    private int cardNum;
    String name;

    public Student(String name){
        this.name = name;
        _studentId = ++studentId;
        cardNum = _studentId + 100;
    }

    public String toString(){
        return String.format("학생이름: %s, 학번: %d, 학생 카드 번호: %d%n", name, _studentId, cardNum);
    }

    /*
    private static int studentId;
    private int cardNum;
    String name;

    public Student(String name){
        this.name = name;
        //studentId++;
        this.cardNum = (studentId++) + 100;
    }

    public String toString(){
        return String.format("학생이름: %s, 학번: %d, 학생 카드 번호: %d%n", name, studentId, cardNum);
    }
    */
}
