package exam02;

public enum Transportation {
    BUS(1350){
        public int getTotal(int person){ //추상메서드 정의
            return getFare() * person;
        }
    },
    SUBWAY(1450){
        public int getTotal(int person){ //추상메서드 정의
            return getFare() * person;
        }
    },
    TAXI(4800){
        public int getTotal(int person){ //추상메서드 정의
            return getFare() * person;
        }
    };

    private final int fare; //초기화값을 고정해서 쓸 목적이므로, 정적상수로 정의

    //public Transportation(){} -> private 외에는 오류 발생!
    Transportation(int fare){ //컴파일러가 private 자동 추가
        this.fare = fare;
    }

    public int getFare(){
        return fare;
    }

    public abstract int getTotal(int person); //구현체가 있어야함.

}
