package ro.mycode.Model;

public class Customer {
    private int id;
    private String email;
    private String password;
    private String full_name;
    public Customer(int id,String email,String password, String full_name){
        this.id=id;
        this.email=email;
        this.password=password;
        this.full_name=full_name;
    }
    public Customer(String propietati){
        String[] line=propietati.split(",");
        this.id=Integer.parseInt(line[0]);
        this.email=line[1];
        this.password=line[2];
        this.full_name=line[3];
    }
    public String descrieClient(){
        String text="";
        text+="Id-ul este " + this.id +"\n";
        text+="Email-ul este " + this.email +"\n";
        text+="Parola este " + this.password +"\n";
        text+="Numele complet este" + this.full_name + "\n";
        return text;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String save(){
        String text="";
        text+=this.id+","+this.email+","+this.password+","+this.full_name;
        return text;
    }
}
