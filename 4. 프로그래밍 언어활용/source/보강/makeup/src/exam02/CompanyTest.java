package exam02;

public class CompanyTest {
    public static void main(String[] args) {
        //Company c1 = new Company();
        //Company c2 = new Company();
        //System.out.println(c1 == c2);
        //기본생성자가 정의된 상태 (기본생성자 -> public)
        //객체 생성에 제한이 없는 통제불가 상태

        //Company c1 = Company.instance;
        //Company.instance = null;
        //값을 넣을 수 있는 통제 불가 상태( public static Company instance = new Company(); 때문)
        //Company c2 = Company.instance;
        //System.out.println(c1==c2);

        Company c1 = Company.getInstance();
        Company c2 = Company.getInstance();
        System.out.println(c1 == c2);
    }
}
