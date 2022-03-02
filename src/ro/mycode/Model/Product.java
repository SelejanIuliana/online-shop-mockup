package ro.mycode.Model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private int stock;
    public Product(int id, String name,int price, String description,int stock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
    }
    public Product(String propietati){
        String[] line=propietati.split(",");
        this.id=Integer.parseInt(line[0]);
        this.name=line[1];
        this.price=Integer.parseInt(line[2]);
        this.description=line[3];
        this.stock=Integer.parseInt(line[4]);
    }
    public String description(){
        String text="";
        text+="Id-ul este " + this.id +"\n";
        text+="Numele este " + this.name+ "\n";
        text+="Produsul este " + this.price+"\n";
        text+="Descrierea produsului este " + this.description+"\n";
        text+="Stocul este " + this.stock+"\n";
        return text;

    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}
    public int getPrice(){return this.price;}
    public void setPrice(int price){this.price=price;}
    public String getDescription(){ return this.description;}
    public void setDescription(String description){this.description=description;}
    public int getStock(){ return  this.stock;}
    public void setStock(int stock){this.stock=stock;}

    public String save(){
        String text="";
        text+=this.id+","+this.name+","+this.price+ ","+ this.description+","+this.stock;
        return text;
    }

}
