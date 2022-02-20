package ro.mycode.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void propietati(){
        Customer customer=new Customer(1,"iulialigia@gmail.com","asasa","Alina Mihaela");
        assertEquals("1,iulialigia@gmail.com,asasa,Alina Mihaela",customer.save());
    }


}