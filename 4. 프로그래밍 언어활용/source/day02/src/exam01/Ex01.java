package exam01;

public class Ex01 {
    public static void main(String[] args) {

        Student s1 = new Student(); // 공간1
        s1.id = 1000; // 인스턴스 변수
        s1.name = "이이름";
        s1.subject = "자바";
        s1.study(); // 인스턴스 메서드

        Student s2 = new Student(); // 공간2
        s2.id = 1001;
        s2.name = "김이름";
        s2.subject = "자바스크립트";

        s2.study();

        System.out.println(s1 == s2);

        Student s3 = s2; // s3 = s2의 주소값 복사
        s3.name="(수정)김이름";
        s3.study();

        s2.study();
        System.out.println(s3 == s2);

        s1 = null; // null 값을 대입하면 참조값이 없어짐.
                   // 객체와의 연결 끊겨 자원으로의 접근 불가능
        s1.study();

         
    }
}
