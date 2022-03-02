package ro.mycode.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycode.Model.Customer;

import static org.junit.jupiter.api.Assertions.*;

class ControlCustomerTest {
    private ControlCustomer controlCustomer;


    public ControlCustomerTest(){

        controlCustomer = new ControlCustomer("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\customer.txt");

    }


    @BeforeEach
    public void preconditie() {
        controlCustomer = new ControlCustomer("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\customer.txt");
    }


    //postconditie


    @AfterEach
    public void postcondite() {

        controlCustomer.clear();
        controlCustomer.save();
    }

    @Test
    public void testAdd() {
        Customer customer = new Customer(1, "ana@yahoo.com","asa", "Ana Crina");
        Customer customer2 = new Customer(2,"iulyya@yahoo.com","cra", "Maria Mindrut");
        Customer customer3 = new Customer(3, "iulialigia@gmail.com"," sad","Raul Mindrut");
        controlCustomer.addCustomer(customer);
        controlCustomer.addCustomer(customer2);
        controlCustomer.addCustomer(customer3);
        assertEquals(3, controlCustomer.size());


    }

    @Test
    public void updateidEmail() {
        Customer customer = new Customer(1, "ana@yahoo.com","asa", "Ana Crina");
        Customer customer2 = new Customer(2,"iulyya@yahoo.com","cra", "Maria Mindrut");
        Customer customer3 = new Customer(3, "iulialigia@gmail.com"," sad","Raul Mindrut");
        controlCustomer.addCustomer(customer);
        controlCustomer.addCustomer(customer2);
        controlCustomer.addCustomer(customer3);
        controlCustomer.updateEmail(1,"marin@gmail.com");
        assertEquals("marin@gmail.com", controlCustomer.getbyid(1).getEmail());

    }



    @Test
    public void updateFullName() {
        Customer customer = new Customer(1, "ana@yahoo.com","asa", "Ana Crina");
        Customer customer2 = new Customer(2,"iulyya@yahoo.com","cra", "Maria Mindrut");
        Customer customer3 = new Customer(3, "iulialigia@gmail.com"," sad","Raul Mindrut");
        controlCustomer.addCustomer(customer);
        controlCustomer.addCustomer(customer2);
        controlCustomer.addCustomer(customer3);
        for(int i=1;i<4;i++){
            if (controlCustomer.getbyid(i).getId()>=5 && controlCustomer.getbyid(i).getId()<=200 ){
                controlCustomer.updateFullName(i, "Crisan Elena");
            }
        }
        for(int i=1;i<4;i++){
            if (controlCustomer.getbyid(i).getId()>=5 && controlCustomer.getbyid(i).getId()<=200 ){
                assertEquals("Crisan Elena",controlCustomer.getbyid(i).getFull_name());
            }
        }
    }

    @Test
    public void testDelete(){
        Customer customer3 = new Customer(3, "iulialigia@gmail.com"," sad","Raul Mindrut");
        controlCustomer.addCustomer(customer3);
        controlCustomer.delete(1);
        assertEquals(null,controlCustomer.getbyid(1));

    }



    @Test
    public void testtoSavedoi(){
        Customer customer3 = new Customer(3, "iulialigia@gmail.com"," sad","Raul Mindrut");
        controlCustomer.addCustomer(customer3);
        controlCustomer.save();
        controlCustomer.load();
        assertEquals("iulialigia@gmail.com",controlCustomer.getbyid(3).getEmail());
    }


}



