package chapter06.exercise;

public class CardTest {
    public static void main(String[] args) {
        CardCompany company = CardCompany.getInstance();

        Card card1 = company.createCard();
        card1.setCustomerName("일이름");
        //card1.setCardNum(10045); - cardNum은 get,set 메서드를 안써야 하는 것 아닌가유?? 궁금증...
        Card card2 = company.createCard();
        card2.setCustomerName("이이름");

        System.out.println(card1.getCustomerName() + " 고객님의 카드번호는 " + card1.cardNum);

        System.out.println(card2.getCustomerName() + " 고객님의 카드번호는 " + card2.cardNum);
    }
}
