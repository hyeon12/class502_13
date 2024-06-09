package chapter06.staticex;

public class StudentTest {
    public static void main(String[] args) {
        Student studentSeo = new Student();
        studentSeo.setStudentName("서이름");
        System.out.println(studentSeo.serialNum);//static변수의 초기값
        studentSeo.serialNum++;//static 변수 증가

        Student studentHong = new Student();
        studentHong.setStudentName("홍이름");
        System.out.println(studentHong.serialNum);//증가된 값 출력
        System.out.println(studentHong.serialNum);
    }
}
