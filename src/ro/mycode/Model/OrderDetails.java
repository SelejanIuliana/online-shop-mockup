package ro.mycode.Model;

public class OrderDetails {
    private int id;
    private int order_id;
    private int product_id;
    private int price;
    private int quantity;
    public OrderDetails(int id, int order_id,int product_id, int price,int quantity){
        this.id=id;
        this.order_id=order_id;
        this.product_id=product_id;
        this.price=price;
        this.quantity=quantity;
    }
    public OrderDetails(String propietati){
        String[] line=propietati.split(",");
        this.id=Integer.parseInt(line[0]);
        this.order_id=Integer.parseInt(line[1]);
        this.product_id=Integer.parseInt(line[2]);
        this.price=Integer.parseInt(line[3]);
        this.quantity=Integer.parseInt(line[4]);
    }
    public String description(){
        String text="";
        text+="Id-ul este " + this.id +"\n";
        text+="Id-ul bonului este " + this.order_id+ "\n";
        text+="Id-ul produsului este " + this.product_id+"\n";
        text+="Pretul este " + this.price+"\n";
        text+="Cantitatea este " + this.quantity+"\n";
        return text;

    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getOrder_id(){
        return this.order_id;
    }
    public void setOrder_id(int order_id){
        this.order_id=order_id;
    }
    public int getProduct_id(){return this.product_id;}
    public void setProduct_id(int product_id){
        this.product_id=product_id;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getQuantity(){return this.quantity;}
    public void setQuantity(int quantity){this.quantity=quantity;}
    public String save(){
        String text="";
        text+=this.id+","+this.order_id+","+this.product_id+ ","+ this.price+","+this.quantity;
        return text;
    }

}
