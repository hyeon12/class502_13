package Coffee_practice;

public class StarCoffee implements Coffee {//가격조회와 총수익
    int totalProfit;
    int price;

    public String brewing(String name){
        totalProfit =+ price;
        return String.format("%s에서 %s을 %d 원으로 구입했습니다. 별카페의 총 수익은 %d%n", "별카페", name, price, totalProfit);
    }

    public int getPrice(String name){
        price = name.equals("라떼")? Menu.STARLATTE : Menu.STARAMERICANO;
        return price;
    }
}
