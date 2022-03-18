package View;

import ro.mycode.Controller.ControlCustomer;
import ro.mycode.Controller.ControlOrder;
import ro.mycode.Controller.ControlOrderDetails;
import ro.mycode.Controller.ControlProduct;
import ro.mycode.Model.Customer;
import ro.mycode.Model.Order;
import ro.mycode.Model.OrderDetails;
import ro.mycode.Model.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class ViewCustomer {
    public ControlOrder controlOrder;
    public ControlOrderDetails controlOrderDetails;
    public ControlProduct controlProduct;
    public Scanner scanner = new Scanner(System.in);
    Customer customer;
    Order order;

    public ViewCustomer() {
        this.controlOrder = new ControlOrder("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\src\\ro\\mycode\\Resources\\oreder.txt");
        this.controlOrderDetails = new ControlOrderDetails("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\src\\ro\\mycode\\Resources\\orederDetails.txt");
        this.controlProduct = new ControlProduct("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\src\\ro\\mycode\\Resources\\product.txt");
        this.customer = new Customer(1, "alina@gamil.com", "anan", "Ana Mindrut");

        this.order = new Order(this.controlOrder.nextValidId(), this.customer.getId(), 0);


    }


    public void meniu() {
        System.out.println("Apasati tasta 1 pentru a afisa toate produsele");
        System.out.println("Apasati tasta 2 pentru a adauga in cos");
        System.out.println("Apasati tasta 3 pentru a vedea ce este in cos");
        System.out.println("Apasati tasta 4 pentru a vedea suma");
        System.out.println("Apasati tasta 5 pentru a vedea cantitatea");

    }

    public void play() {
        boolean play = true;
        while (play) {
            meniu();
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton) {
                case 1:

                    controlProduct.afisareProduct();
                    break;
                case 2:
                    addCos();
                    break;
                case 3:
                    cos();
                    break;
                case 4:
                    sumadeplata();
                    break;
                case 5:;
                    cantitateRamasa();
                    break;
            }
        }
    }


    public void addCos() {
        System.out.println("Ce produs doriti sa adaugati");
        String nume=scanner.nextLine();
        System.out.println("Cate Produse doriti sa adaugati");
        int cantitate=Integer.parseInt(scanner.nextLine());
        if(controlProduct.isNume(nume)==true && controlProduct.isStock(cantitate)==true){
            System.out.println("Produsul se afla in stoc");

            Product p= this.controlProduct.product(nume);

                  OrderDetails  x = new OrderDetails(
                  controlOrderDetails.nextValidId(),
                  this.order.getId(),
                  p.getId(),
                  p.getPrice()*cantitate,
                  cantitate
                    );

            System.out.println(x.description());
                  this.controlOrderDetails.addOrderDetails(x);

        }

    }

    public void cos(){
       ArrayList<OrderDetails>lista =controlOrderDetails.getByOrderId(this.order.getId());
        String text="A-ti adaugat";
       for (OrderDetails v: lista){

           text+="Produsul "+controlProduct.getbyid(v.getProduct_id()).getName()+"\n";

           text+="Nr buc"+v.getQuantity()+"\n";

           text+="Pret "+v.getPrice();



       }

       text+="Cu totalul de "+this.order.getAmmount()+"\n";

        System.out.println(text);
    }

    public void sumadeplata(){
        System.out.println("Introduceti id-ul");
        int id= Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti cantitatea");
        int cantitate = Integer.parseInt(scanner.nextLine());

        OrderDetails m = controlOrderDetails.gettipimprumut(id);

        if(controlOrderDetails.isid(id)==true) {
            System.out.println("Suma de plata este" + controlOrderDetails.total(id,cantitate));
        }else {
                System.out.println("ID-ul contului este gresit");
            }



    }
    public void cantitateRamasa(){
        System.out.println("Introduceti id-ul");
        int id= Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti cantitatea");
        int cantitate = Integer.parseInt(scanner.nextLine());

        OrderDetails m = controlOrderDetails.gettipimprumut(id);

        if(controlOrderDetails.isid(id)==true) {
            System.out.println("Cantitate ramasa" + controlOrderDetails.cantitaterRamasa(id,cantitate));
        }else {
            System.out.println("ID-ul contului este gresit");
        }



    }

}
