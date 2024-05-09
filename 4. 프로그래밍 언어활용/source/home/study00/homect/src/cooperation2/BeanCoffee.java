package cooperation2;

public class BeanCoffee implements Coffee {
    int totalProfit; //수익
    int price; //커피가격


    public String brewing(String name) {//커피 만들기! 수익

        totalProfit += getPrice(name); //totalProfit 수익 = 수익+커피가격

        return String.format("%s에서 %s를 %d원에 구입했습니다. 커피빈의 총 수익은 %d%n", "커피빈", name, getPrice(name), totalProfit);
    }

    @Override
    public int getPrice(String name) {//name=커피이름, 커피마다 가격 조회
        int price = name.equals("라떼") ? Menu.BEANLATTE :  Menu.BEANAMERICANO; //이름에 맞는 상수의 값 출력
        this.price = price; //해당하는 커피가격 대입
        return price; //반환값 = 해당 커피가격
    }


}
