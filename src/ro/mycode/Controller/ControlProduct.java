package ro.mycode.Controller;

import ro.mycode.Model.OrderDetails;
import ro.mycode.Model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlProduct {
    public ArrayList<Product> products;
    private String path;
    public ControlProduct(String path) {
        this.products=new ArrayList();
        this.path=path;
        load();
    }
    public void load() {
        File file = new File(path);

        try {
            try(Scanner scanner = new Scanner(file)){
                while (scanner.hasNextLine()) {
                    this.products.add(new Product(scanner.nextLine()));
                }

            }


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void afisareProduct() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).description());
        }
    }
    public void addCustomer(Product product){
        this.products.add(product);
    }

    public void updatename(int id, String  name){
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
               products.get(i).setName(name);
            }
        }
    }
    public void updatePrice(int id, int price){
        for (int i=0; i<products.size();i++){
            if(products.get(i).getId()==id){
               products.get(i).setPrice(price);
            }
        }
    }
    public void updateDescription(int id, String description){
        for (int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
               products.get(i).setDescription(description);
            }
        }
    }
    public void updateStock(int id, int stock){
        for (int i=0; i<products.size();i++){
            if(products.get(i).getId()==id){
               products.get(i).setStock(stock);
            }
        }
    }

    public void delete(int id){
        for (int i=0;i<products.size(); i++){
            if(products.get(i).getId()==id){
               products.remove(i);
            }
        }
    }
    public int nextValidId(){

        if(this.products.size()==0){
            return 1;
        }else{
            return this.products.get(this.products.size()-1).getId()+1;
        }
    }

    public ArrayList<Product>  listaProduse(int personId){
        ArrayList<Product>products=  new ArrayList<>();

        for (int i=0; i<products.size();i++){
            if(products.get(i).getId()==personId){
               products.add(products.get(i));
            }
        }
        return products;
    }

    public String toSave(){
        String text="";
        for (Product n:products){
            text+=n.save()+"\n";
        }
        return text;
    }
    public void save(){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.print(this.toSave());
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public Product getbyid(int id){
        for (int i=0; i<products.size();i++){
            if(products.get(i).getId()==id){
                return products.get(i);
            }
        }
        return null;
    }

    public void clear(){
        this.products.clear();
    }

    public  int size(){

        return this.products.size();
    }
}







