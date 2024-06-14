package exam01;

public class Student {
    static int id;
    private String name;
    private String subject;

    public Student(int id, String name, String subject){
        Student.id = id;
        this.name = name;
        this.subject = subject;
    }

    public static void staticMethod(){
        System.out.println("정적메서드~ 난 객체생성 안해도 쓸 수 있지~~~");
        //this.name = 1000; 객체 생성 관련X 메서드로, this 존재X
        //인스턴스 자원은 정적 메서드에서 접근 불가
        id = 1000; //정적 자원만 접근 가능
    }

    public void instantMethod(){
        System.out.println("인스턴스 메서드.. 객체 생성 필수..");
        //System.out.println("name=" + this.name);
        System.out.println("name=" + name);//객체의 자원임이 명확하므로 this 생략 가능
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
