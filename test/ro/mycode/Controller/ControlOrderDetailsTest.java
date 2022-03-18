package ro.mycode.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycode.Model.OrderDetails;

import static org.junit.jupiter.api.Assertions.*;

class ControlOrderDetailsTest {

    private ControlOrderDetails controlOrderDetails;


    public ControlOrderDetailsTest(){

        controlOrderDetails = new ControlOrderDetails("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\orderdetails.txt");

    }


    @BeforeEach
    public void preconditie() {
        controlOrderDetails = new ControlOrderDetails("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\orderdetails.txt");
    }


    //postconditie


    @AfterEach
    public void postcondite() {

        controlOrderDetails.clear();
        controlOrderDetails.save();
    }

    @Test
    public void testAdd() {
        OrderDetails orderDetails  = new OrderDetails(1,22,34,45,56 );
        OrderDetails orderDetails1 = new OrderDetails(2, 33, 45, 56, 8);
        OrderDetails orderDetails2 = new OrderDetails(3, 34, 55, 76, 7);
        controlOrderDetails.addOrderDetails(orderDetails);
        controlOrderDetails.addOrderDetails(orderDetails1);
        controlOrderDetails.addOrderDetails(orderDetails2);
        assertEquals(3, controlOrderDetails.size());


    }

    @Test
    public void updateProduct() {
        OrderDetails orderDetails  = new OrderDetails(1,22,34,45,56 );
        OrderDetails orderDetails1 = new OrderDetails(2, 33, 45, 56, 8);
        OrderDetails orderDetails2 = new OrderDetails(3, 34, 55, 76, 7);
        controlOrderDetails.addOrderDetails(orderDetails);
        controlOrderDetails.addOrderDetails(orderDetails1);
        controlOrderDetails.addOrderDetails(orderDetails2);
        for (int i = 1; i <= 4; i++) {
            if (controlOrderDetails.isid(1) == true) {
                controlOrderDetails.updateProduct(i, 44);
            }
        }
        for (int i = 1; i <= 4; i++) {
            if (controlOrderDetails.isid(1) == true) {

                assertEquals(44, controlOrderDetails.getbyid(1).getProduct_id());
            }
        }

    }

    @Test
    public void updateOrder() {
        OrderDetails orderDetails  = new OrderDetails(1,22,34,45,56 );
        OrderDetails orderDetails1 = new OrderDetails(2, 33, 45, 56, 8);
        OrderDetails orderDetails2 = new OrderDetails(3, 34, 55, 76, 7);
        controlOrderDetails.addOrderDetails(orderDetails);
        controlOrderDetails.addOrderDetails(orderDetails1);
        controlOrderDetails.addOrderDetails(orderDetails2);
        controlOrderDetails.updateOderid(2,34);
        assertEquals(34, controlOrderDetails.getbyid(2).getOrder_id());
    }
    @Test
    public void updatePrice() {
        OrderDetails orderDetails  = new OrderDetails(1,22,34,45,56 );
        OrderDetails orderDetails1 = new OrderDetails(2, 33, 45, 56, 8);
        OrderDetails orderDetails2 = new OrderDetails(3, 34, 55, 76, 7);
        controlOrderDetails.addOrderDetails(orderDetails);
        controlOrderDetails.addOrderDetails(orderDetails1);
        controlOrderDetails.addOrderDetails(orderDetails2);
        controlOrderDetails.updateprice(2,33);
        assertEquals(33, controlOrderDetails.getbyid(2).getPrice());
    }

    @Test
    public void updateQuantity() {
        OrderDetails orderDetails  = new OrderDetails(1,22,34,45,56 );
        OrderDetails orderDetails1 = new OrderDetails(2, 33, 45, 56, 8);
        OrderDetails orderDetails2 = new OrderDetails(3, 34, 55, 76, 7);
        controlOrderDetails.addOrderDetails(orderDetails);
        controlOrderDetails.addOrderDetails(orderDetails1);
        controlOrderDetails.addOrderDetails(orderDetails2);
        for (int i=0; i<=4;i++){
            if(controlOrderDetails.isid(1)==true){
               controlOrderDetails.updateQuantity(i,190);
            }
        }
        for (int i=0;i<=4;i++){
            if(controlOrderDetails.isid(1)==true){
                assertEquals(190, controlOrderDetails.getbyid(2).getQuantity());
            }
        }
    }
    @Test
    public void testDelete(){
        OrderDetails orderDetails2 = new OrderDetails(1,22,34,45,56 );
        controlOrderDetails.addOrderDetails(orderDetails2);
        controlOrderDetails.delete(1);
        assertEquals(null,controlOrderDetails.getbyid(1));

    }
    @Test
    public void testsuma(){
        OrderDetails orderDetails2 = new OrderDetails(1,22,34,45,56 );
        controlOrderDetails.addOrderDetails(orderDetails2);
        controlOrderDetails.total(1,2);
        assertEquals(90,controlOrderDetails.getbyid(1).getPrice());

    }


    @Test
    public void testtoSavedoi(){
        OrderDetails orderDetails2 = new OrderDetails(1,22,34,45,56 );
        controlOrderDetails.addOrderDetails(orderDetails2);
        controlOrderDetails.save();
        controlOrderDetails.load();
        assertEquals(22,controlOrderDetails.getbyid(1).getOrder_id());
    }
}


