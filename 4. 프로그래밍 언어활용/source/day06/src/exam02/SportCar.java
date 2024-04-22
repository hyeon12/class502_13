package exam02;

public class SportCar extends Car{
    public void start(){
        System.out.println("시동 걸기");
    }
    public void press(){
        System.out.println("악셀레이터 밟고");
    }
    public void turnoff(){
        System.out.println("시동 끄기");
    }
/*
    public void run(){
        //메서드 재정의 가능 -> 템플릿 메서드 패턴
    }

 */
}
