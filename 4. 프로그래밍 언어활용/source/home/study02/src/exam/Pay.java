package exam;

public class Pay {
    public int solution(int price) {

        price = 399999;

        int pay = 0;
        if (price >= 500000) {
            pay = (int)(price - (price * 0.2));
        } else if (price >= 300000) {
            pay = (int)(price - (price * 0.1));
        } else if (price >= 100000) {
            pay = (int)(price - (price * 0.05));
        } else {
            pay = price;
        }
        return pay;
    }

    public static void main(String[] args) {
        Pay p1 = new Pay();
        System.out.println(p1.solution(400000));
    }
}
