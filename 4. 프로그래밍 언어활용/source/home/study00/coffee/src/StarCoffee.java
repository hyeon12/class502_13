public class StarCoffee {
    String menuName;
    int price;

    public static final int STARAMERICANO = 4000;
    public static final int STARLATTE = 4500;

    public void make(String menuName) {
        this.price = menuName.equals("라떼")? STARLATTE : STARAMERICANO ;
        System.out.printf("별다방에서 %d원을 내고 %s를 사 마셨습니다.%n", price, menuName);
    }

    @Override
    public String toString() {
        return "CoffeeBean{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                '}';
    }
}
