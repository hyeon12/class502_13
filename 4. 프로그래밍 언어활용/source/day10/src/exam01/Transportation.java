package exam01;

public enum Transportation {
    BUS(1400),
    TAXI(4500),
    SUBWAY(1300);

    private final int fare;

    Transportation(int fare){
        //생성자 정의하더라도 접근제어자 private 으로 외부 접근 통제된 상태!!!
        this.fare = fare;
    }

    public int getFare(){
        return fare;
    }

    public abstract int getTotal(int person);
}
