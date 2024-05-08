package exam03_card;

public class Singleton {
    //필요할 때 객체를 한 개 생성하고 공유하는 것
    private static Singleton instance; //-(2)

    private Singleton(){} //-(1)

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
