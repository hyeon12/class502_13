package chapter06.singleton;

public class CompanyTest {
    public static void main(String[] args){
        //클래스 이름으로 getInstance() 호출 - 참조변수에 대입
        Company myCompany1 = Company.getInstance();
        Company myCompany2 = Company.getInstance();

        System.out.println(myCompany1 == myCompany2);
    }
}
