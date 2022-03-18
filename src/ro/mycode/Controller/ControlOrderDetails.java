package ro.mycode.Controller;

import ro.mycode.Model.Order;
import ro.mycode.Model.OrderDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlOrderDetails {
    public ArrayList<OrderDetails> orderDetails;
    private String path;
    public ControlOrderDetails(String path) {
        this.orderDetails=new ArrayList();
        this.path=path;
        load();
    }
    public void load() {
        File file = new File(path);

        try {
            try(Scanner scanner = new Scanner(file)){
                while (scanner.hasNextLine()) {
                    this.orderDetails.add(new OrderDetails(scanner.nextLine()));
                }

            }


        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void afisareOrdersdetails() {
        for (int i = 0; i < orderDetails.size(); i++) {
            System.out.println(orderDetails.get(i).description());
        }
    }
    public void addOrderDetails(OrderDetails orderDetails){
        this.orderDetails.add(orderDetails);
    }

    public void updateOderid(int id, int  orderid){
        for (int i=0;i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
                orderDetails.get(i).setOrder_id(orderid);
            }
        }
    }
    public void updateProduct(int id, int product){
        for (int i=0; i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
               orderDetails.get(i).setProduct_id(product);
            }
        }
    }
    public void updateprice(int id, int  price){
        for (int i=0;i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
                orderDetails.get(i).setPrice(price);
            }
        }
    }
    public void updateQuantity(int id, int quantity){
        for (int i=0; i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
                orderDetails.get(i).setQuantity(quantity);
            }
        }
    }

    public void delete(int id){
        for (int i=0;i<orderDetails.size(); i++){
            if(orderDetails.get(i).getId()==id){
                orderDetails.remove(i);
            }
        }
    }
    public int nextValidId(){

        if(this.orderDetails.size()==0){
            return 1;
        }else{
            return this.orderDetails.get(this.orderDetails.size()-1).getId()+1;
        }
    }



    public String toSave(){
        String text="";
        for (OrderDetails n:orderDetails){
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
    //todo funtctie ce primeste ca parametru un orderiD si retunreaza o lista
    //todo: cu detaliile ce contin comanda respectiva


    public  ArrayList<OrderDetails> getByOrderId(int orderId){

         ArrayList<OrderDetails> cos=new ArrayList<>();
         for(int i= 0; i<this.orderDetails.size();i++){

             if(orderDetails.get(i).getOrder_id()==orderId){
                 cos.add(orderDetails.get(i));
             }
         }
         return orderDetails;
    }

    public OrderDetails getbyid(int id){
        for (int i=0; i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
                return orderDetails.get(i);
            }
        }
        return null;
    }
    public OrderDetails gettipimprumut(int id){
        for (OrderDetails m: orderDetails){
            if(m.getProduct_id()==id){
                return m;
            }
        }
        return null;
    }

    public boolean isid(int id){
        for(int i=0; i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        this.orderDetails.clear();
    }

    public  int size(){

        return this.orderDetails.size();
    }
    public int total(int id, int nr) {
        int nrnou=0;
        for (int i = 0; i < orderDetails.size(); i++) {
            if (orderDetails.get(i).getQuantity()<nr && orderDetails.get(i).getId()==id) {
                nrnou = orderDetails.get(i).getPrice()*nr;

            }
        }
        return nrnou;
    }
    public int cantitaterRamasa(int id, int nr) {
            int nrnou=0;
            for (int i = 0; i < orderDetails.size(); i++) {
                if (orderDetails.get(i).getQuantity()<nr && orderDetails.get(i).getId()==id) {
                    nrnou = orderDetails.get(i).getQuantity()-nr;

                }
            }
            return nrnou;

    }
}





