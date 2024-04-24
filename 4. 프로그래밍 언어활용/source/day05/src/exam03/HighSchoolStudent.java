package exam03;

public class HighSchoolStudent extends Student {

    public HighSchoolStudent() {
        super(1000, "이이름");
        // 상위클래스에 기본 생성자가 없으면 오류 발생함. - super();만 생성되기 때문!
        // (1) super()에 매개변수 넣어서 Student 를 객체로 만들거나!
        // (2) 상위 클래스에 기본생성자 추가해서 객체로 만드는 것
    }

    @Override
    public String toString() {
        return "HighSchoolStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
