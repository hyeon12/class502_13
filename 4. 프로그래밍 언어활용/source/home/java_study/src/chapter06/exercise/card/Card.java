package chapter06.exercise.card;

public class Card {
    static int serialNum = 1000;
    int cardNum;
    String customerName;

    public Card(){
        serialNum++;
        cardNum = serialNum;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String name){
        this.customerName = name;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNumber) {
        this.cardNum = cardNumber;
    }
}
