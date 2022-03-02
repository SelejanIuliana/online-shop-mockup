package ro.mycode.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycode.Model.Order;
import ro.mycode.Model.Product;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrderTest {
    private ControlOrder controlOrder;


    public ControlOrderTest(){

        controlOrder = new ControlOrder("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\order.txt");

    }


    @BeforeEach
    public void preconditie() {
        controlOrder = new ControlOrder("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\order.txt");
    }


    //postconditie


    @AfterEach
    public void postcondite() {

        controlOrder.clear();
        controlOrder.save();
    }

    @Test
    public void testAdd() {
        Order order = new Order(1,22,33);
        Order order1 = new Order(2,24, 45);
        Order order2 = new Order(3, 34,44);
        controlOrder.addOrder(order);
        controlOrder.addOrder(order1);
        controlOrder.addOrder(order2);
        assertEquals(3, controlOrder.size());


    }

    @Test
    public void updateAmount() {
        Order order = new Order(1,22,33);
        Order order1 = new Order(2,24, 45);
        Order order2 = new Order(3, 34,44);
        controlOrder.addOrder(order);
        controlOrder.addOrder(order1);
        controlOrder.addOrder(order2);
        controlOrder.updateAmount(1,55);
        assertEquals(55, controlOrder.getbyid(1).getAmmount());

    }



    @Test
    public void updateCustomer() {
        Order order = new Order(1,22,33);
        Order order1 = new Order(2,24, 45);
        Order order2 = new Order(3, 34,44);
        controlOrder.addOrder(order);
        controlOrder.addOrder(order1);
        controlOrder.addOrder(order2);
        controlOrder.updateCustomer(1,44);
        assertEquals(44, controlOrder.getbyid(1).getCustomer_id());
    }


    @Test
    public void testDelete(){
        Order order2 = new Order(3, 34,44);
        controlOrder.addOrder(order2);
        controlOrder.delete(1);
        assertEquals(null,controlOrder.getbyid(1));

    }



    @Test
    public void testtoSavedoi(){
        Order order2 = new Order(3, 34,44);
        controlOrder.addOrder(order2);
        controlOrder.save();
        controlOrder.load();
        assertEquals(44,controlOrder.getbyid(3).getAmmount());
    }


}

