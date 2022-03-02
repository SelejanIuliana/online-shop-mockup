package ro.mycode.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDetailsTest {
    @Test
    public void propietati(){
        OrderDetails orderDetails=new OrderDetails(1,22,33,23,34);
        assertEquals("1,22,33,23,34",orderDetails.save());
    }

}