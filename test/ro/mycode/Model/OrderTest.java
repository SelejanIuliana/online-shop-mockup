package ro.mycode.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void propietatiorder(){
        Order order=new Order(1,2,3);
        assertEquals("1,2,3",order.save());
    }

}