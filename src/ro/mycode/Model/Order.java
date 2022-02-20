package ro.mycode.Model;

public class Order {
    private int id;
    private int customer_id;
    private  int ammount;
    public Order(int id, int customer_id,int ammount){
        this.id=id;
        this.customer_id=id;
        this.ammount=ammount;
    }
}
