package cooperation2;

public class StarCoffee implements Coffee {
    int totalProfit; //수익
    int price; //커피가격

    public String brewing(String name) { //커피만들어서 수익계산

        totalProfit += getPrice(name); //수익은? 총수익+커피가격

        return String.format("%s에서 %s를 %d원에 구입했습니다. 커피빈의 총 수익은 %d%n", "커피빈", name, getPrice(name), totalProfit);
    }

    @Override
    public int getPrice(String name) { //name=커피이름, 커피가격 조회
        int price = name.equals("라떼") ? Menu.STARLATTE :  Menu.STARAMERICANO;
        this.price = price;
        return price;
    }

}
