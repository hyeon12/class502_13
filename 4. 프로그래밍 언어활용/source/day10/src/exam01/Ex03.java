package exam01;

public class Ex03 {
    public static void main(String[] args) {
        Transportation BUS = Transportation.BUS;
        System.out.println(BUS instanceof Transportation);

        Enum trans = BUS; //다형성으로서 가능!
    }
}
