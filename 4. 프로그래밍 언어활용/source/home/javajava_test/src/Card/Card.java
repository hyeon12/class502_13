package Card;

public class Card {
    int serialNum;
    String customerName;

    public Card(){
        serialNum=0;
    }

    public void member(String customerName) {
        ++serialNum;
        System.out.printf("%s의 카드번호는 %d입니다.%n", customerName, serialNum);
    }

    @Override
    public String toString() {
        return "Card{" +
                "serialNum=" + serialNum +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
