public class Card {
    public static int CardNum = 1000;
    public String customerName;

    public Card(String customerName){
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "customerName='" + customerName + '\'' +
                '}';
    }
}
