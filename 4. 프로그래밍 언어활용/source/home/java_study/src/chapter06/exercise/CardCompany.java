package chapter06.exercise;

public class CardCompany {

    private static CardCompany instance = new CardCompany();

    private CardCompany(){}

    public static CardCompany getInstance(){
        if(instance == null){
            instance = new CardCompany();
        }
        return instance;
    }

    //따로 Card 메서드를 만드는 이유 - serialNum의 증가를 위해?
    //CardCompany 클래스에 Card까지 정의했더니 serialNum이 증가하지 않았음
    // -> 왜 일까?
    public Card createCard(){ //반환값 자료형 Card
        Card card = new Card();
        return card;
    }
}
