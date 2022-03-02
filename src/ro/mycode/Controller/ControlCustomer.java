package ro.mycode.Controller;
import ro.mycode.Model.Customer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlCustomer {
    public ArrayList<Customer> customers;
    private String path;
    public ControlCustomer(String path) {
        this.customers=new ArrayList();
        this.path=path;
        load();
        }
        public void load() {
            File file = new File(path);

            try {
                try(Scanner scanner = new Scanner(file)){
                    while (scanner.hasNextLine()) {
                        this.customers.add(new Customer(scanner.nextLine()));
                    }

                }


            } catch (Exception e) {

                e.printStackTrace();
            }

        }

        public void afisareCustomer() {
            for (int i = 0; i < customers.size(); i++) {
                System.out.println(customers.get(i).descrieClient());
            }
        }
        public void addCustomer(Customer customer){
            this.customers.add(customer);
        }
        public void updateEmail(int id, String email){
            for (int i=0;i<customers.size();i++){
                if(customers.get(i).getId()==id){
                    customers.get(i).setEmail(email);
                }
            }
        }
        public void updatePassword(int id, String password){
            for (int i=0; i<customers.size();i++){
                if(customers.get(i).getId()==id){
                    customers.get(i).setPassword(password);
                }
            }
        }
    public void updateFullName(int id, String fullname){
        for (int i=0; i<customers.size();i++){
            if(customers.get(i).getId()==id){
                customers.get(i).setFull_name(fullname);
            }
        }
    }
        public void delete(int id){
            for (int i=0;i<customers.size(); i++){
                if(customers.get(i).getId()==id){
                    customers.remove(i);
                }
            }
        }
        public int nextValidId(){

            if(this.customers.size()==0){
                return 1;
            }else{
                return this.customers.get(this.customers.size()-1).getId()+1;
            }
        }

        public ArrayList<Customer>  listaCustomer(int personId){
            ArrayList<Customer>customers=  new ArrayList<>();

            for (int i=0; i<customers.size();i++){
                if(customers.get(i).getId()==personId){
                    customers.add(customers.get(i));
                }
            }
            return customers;
        }

        public String toSave(){
            String text="";
            for (Customer n:customers){
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
        public Customer getbyid(int id){
            for (int i=0; i<customers.size();i++){
                if(customers.get(i).getId()==id){
                    return customers.get(i);
                }
            }
            return null;
        }

        public void clear(){
            this.customers.clear();
        }

        public  int size(){

            return this.customers.size();
        }
    }



