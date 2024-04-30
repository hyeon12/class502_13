package Coffee_practice;

public class BeanCoffee implements Coffee {
    int totalProfit;
    int price;


    @Override
    public String brewing(String name) {
        totalProfit =+ getPrice(name);
        return String.format("%s에서 %s를 %d원으로 구입했습니다.%n 콩카페의 총 수익은 %d이며", "커피빈", name, price, totalProfit);
    }

    public int getPrice(String name) {
        price = name.equals("라떼") ? Menu.BEANLATTE : Menu.BEANAMERICANO;

        return price;
    }
}
