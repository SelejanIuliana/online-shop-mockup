package ro.mycode.Model;

public class Order {
    private int id;
    private int customer_id;
    private  int ammount;
    public Order(int id, int customer_id,int ammount){
        this.id=id;
        this.customer_id=customer_id;
        this.ammount=ammount;
    }
    public Order(String propietati){
        String[] line=propietati.split(",");
        this.id=Integer.parseInt(line[0]);
        this.customer_id=Integer.parseInt(line[1]);
        this.ammount=Integer.parseInt(line[2]);
    }
    public String description(){
        String text="";
        text+="Id-ul este " + this.id +"\n";
        text+="Id-ul clientului este " + this.customer_id+ "\n";
        text+="Id-ul contului este" + this.ammount+"\n";
        return text;

    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getCustomer_id(){
        return this.customer_id;
    }
    public void setCustomer_id(int customer_id){
        this.customer_id=customer_id;
    }

    public int getAmmount(){
        return this.ammount;
    }

    public void setAmmount(int ammount){
        this.ammount=ammount;
    }

    public String save(){
        String text="";
        text+=this.id+","+this.customer_id+","+this.ammount;
        return text;
    }

}
