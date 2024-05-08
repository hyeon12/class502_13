package student;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("일이름");
        Student s2 = new Student("이이름");

        System.out.println(s1);
        System.out.println(s2);//왜 학번 출력이 이상하게 되지?ㅜㅜ
    }
}
