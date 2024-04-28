package card;

public class Card {
    static int serialNum = 1000;
    String customerName;

    public Card(){
        serialNum++;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String name){
        this.customerName = name;
    }
}
