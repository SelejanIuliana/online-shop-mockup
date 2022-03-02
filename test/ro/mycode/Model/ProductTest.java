package ro.mycode.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void propietati(){
        Product product=new Product(1,"Alina Mihaela",34,"alimente",33);
        assertEquals("1,Alina Mihaela,34,alimente,33",product.save());
    }

}