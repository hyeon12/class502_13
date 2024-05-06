package Coffee;

public class StarCoffee {
    int price;
    String menuName;

    static int STARAMERICANO = 4000;
    static int STARLATTE = 5000;

    public void order(String menuName){
        this.price = menuName.equals("라떼") ? STARLATTE : STARAMERICANO;
        System.out.printf("%d원을 내고 ", price);
    }

    public void make(String menuName){
        System.out.printf("별다방에서 %s를 사마셨습니다.%n", menuName);
    }

    @Override
    public String toString() {
        return "StarCoffee{" +
                "price=" + price +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
