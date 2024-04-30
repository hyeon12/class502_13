package card;

public class CardNumTest {
    public static void main(String[] args) {

        CardCompany company = CardCompany.getInstance();

        Card card1 = new Card();
        card1.setCustomerName("고객1");
        System.out.println(Card.serialNum);
        System.out.println(card1.getCustomerName()+"카드번호:"+Card.serialNum);

        Card card2 = new Card();
        card2.setCustomerName("고객2");
        System.out.println(Card.serialNum);
        System.out.println(card2.getCustomerName()+"카드번호:"+Card.serialNum);

    }
}
