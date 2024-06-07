package chapter05.Alone;

public class ShoppingMall {
    String orderNo;
    String id;
    String orderDate;
    String consumerNm;
    String orderGoodsNo;
    String address;

    public static void main(String[] args) {
        ShoppingMall sh = new ShoppingMall();
        sh.address = "서울시 영등포구 여의도동 20번지";
        sh.id = "abc123";
        sh.consumerNm = "홍길순";
        sh.orderGoodsNo = "PD0345-12";
        sh.orderDate = "2018년 3월 12일";
        sh.orderNo = "201803120001";

        System.out.println("주문 번호 : " + sh.orderNo);
        System.out.println("주문자 아이디 : " + sh.id);
        System.out.println("주문 날짜 : " + sh.orderDate);
        System.out.println("주문자 이름 : " + sh.consumerNm);
        System.out.println("주문 상품 번호 : " + sh.orderGoodsNo);
        System.out.println("배송 주소 : " + sh.address);
    }
}
