package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Order order = new Order();
        order.buy(); //order 내부에 객체 생성
        order.sell();

        Buyer buyer = order;
        buyer.buy();

        Seller seller = order;
        seller.sell();
    }
}
