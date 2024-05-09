package shopping;

public class Order {
    String OrderNo;
    String id;
    String date;
    String name;
    String productNum;
    String address;

    @Override
    public String toString() {
        return  "OrderNo=" + OrderNo + '\n'+
                "id=" + id + '\n' +
                "date=" + date + '\n'+
                "name=" + name + '\n' +
                "productNum=" + productNum + '\n'+
                "address=" + address;
    }
}
