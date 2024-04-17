package exam01;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public Schedule() {
        this(2024, 4, 17);
    }

    public Schedule(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year; // 멤버변수(인스턴스변수)의 year, 명확할때는 생략 가능하다.
    }

    public void setYear(int year) {
        this.year = year; //지역 변수의 year 인지, 멤버변수의 year 인지 헷갈릴때는 this 로 구분!!
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (this.month == 2 && day > 28){
            day = 28; // 검증 가능
        }

        this.day = day;
    }

    void showDate(){
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
        //=this.year, this.month, this.day -> this 생략된 것. 멤버변수
        // 자원에 접근하기 위한 주소값이 필요하기 때문에 this 사용
        //showDate가 호출되려면 이미 객체가 만들어진 상태여야함. 즉, this 값이 이미 존재하는 것.
        printThis(); //this.printThis(); this 생략 가능
    }

    public void printThis() {
        System.out.println(this);
    }

    public Schedule returnThis() {
        return this;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
