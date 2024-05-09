public class CoffeeBean{
    String menuName;
    int price;

    public static final int BEANAMERICANO = 3800;
    public static final int BEANLATTE = 4300;

    public void make(String menuName) {
        this.price = menuName.equals("라떼")? BEANLATTE : BEANAMERICANO ;
        System.out.printf("커피빈에서 %d원을 내고 %s를 사 마셨습니다.%n", price, menuName);
    }

    @Override
    public String toString() {
        return "CoffeeBean{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                '}';
    }
}
