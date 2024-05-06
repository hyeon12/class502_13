package Coffee;

public class BeanCoffee{
    int price;
    String menuName;

    static int BEANAMERICANO = 3500;
    static int BEANLATTE = 4500;

    public void order(String menuName){
        this.price = menuName.equals("라떼") ? BEANLATTE : BEANAMERICANO;
        System.out.printf("%d원을 내고 ", price);
    }

    public void make(String menuName){
        System.out.printf("콩다방에서 %s를 사마셨습니다.%n", menuName);
    }

    @Override
    public String toString() {
        return "BeanCoffee{" +
                "price=" + price +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
