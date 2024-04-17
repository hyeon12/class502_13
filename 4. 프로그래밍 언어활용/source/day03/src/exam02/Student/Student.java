package exam02.Student;

public class Student {
    public static int id;
    private String name = "이이름";
    //객체 이전에 class 가 있음. 아직 객체 X
    //정의만 한 상태, 값X -> 객체가 되면 변수공간에 값을 할당함.
    private String subject;


    public Student() {}

    public Student(int id, String name, String subject){//초기화
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public static void staticMethod() {
        //객체와 상관 없이 사용 가능, this 지역 변수X -> 객체의 자원 접근x
        System.out.println("정적 메서드!!");
        //this.name = "이이름";
        //this.instanceMethod();
    }

    public void instanceMethod() { // this 지역변수 0 : 객체 자원 접근
        System.out.println("인스턴스 메서드!!");
        System.out.println(this.name);

        //정적 자원은 객체 생성 이전부터 존재
        staticMethod();
        id = 1000;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
