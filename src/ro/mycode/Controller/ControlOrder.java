package ro.mycode.Controller;

import ro.mycode.Model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlOrder {
    public ArrayList<Order> orders;
    private String path;
    public ControlOrder(String path) {
         this.orders=new ArrayList();
         this.path=path;
            load();
        }
    public void load() {
        File file = new File(path);

        try {
             try(Scanner scanner = new Scanner(file)){
                 while (scanner.hasNextLine()) {
                     this.orders.add(new Order(scanner.nextLine()));
                    }

                }


            } catch (Exception e) {

                e.printStackTrace();
            }

        }

        public void afisareOrders() {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println(orders.get(i).description());
            }
        }
        public void addOrder(Order order){
            this.orders.add(order);
        }
        public void updateAmount(int id, int amount){
            for (int i=0;i<orders.size();i++){
                if(orders.get(i).getId()==id){
                   orders.get(i).setAmmount(amount);
                }
            }
        }
        public void updateCustomer(int id, int customer){
            for (int i=0; i<orders.size();i++){
                if(orders.get(i).getId()==id){
                   orders.get(i).setCustomer_id(customer);
                }
            }
        }

        public void delete(int id){
            for (int i=0;i<orders.size(); i++){
                if(orders.get(i).getId()==id){
                   orders.remove(i);
                }
            }
        }
        public int nextValidId(){

            if(this.orders.size()==0){
                return 1;
            }else{
                return this.orders.get(this.orders.size()-1).getId()+1;
            }
        }

        public ArrayList<Order>  listaOrder(int personId){
            ArrayList<Order>orders=  new ArrayList<>();

            for (int i=0; i<orders.size();i++){
                if(orders.get(i).getId()==personId){
                    orders.add(orders.get(i));
                }
            }
            return orders;
        }

        public String toSave(){
            String text="";
            for (Order n:orders){
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
        public Order getbyid(int id){
            for (int i=0; i<orders.size();i++){
                if(orders.get(i).getId()==id){
                    return orders.get(i);
                }
            }
            return null;
        }

        public void clear(){
            this.orders.clear();
        }

        public  int size(){

            return this.orders.size();
        }
    }





