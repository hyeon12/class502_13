package Card;

public class Company {
    public static Company instance;

    private Company(){}

    public static void getInstance(){
        if(instance != null){
            Company company = instance;
        }
    }
}
