package exam04;

public interface Buyer {
    void buy();

    default void order(){
        System.out.println("buyer에서 주문");

        privateMethod();
    }

    private void privateMethod(){}
}
