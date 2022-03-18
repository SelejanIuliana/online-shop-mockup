package ro.mycode.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.mycode.Model.Product;

import static org.junit.jupiter.api.Assertions.*;

class ControlProductTest {
    private ControlProduct controlProduct;


    public ControlProductTest(){

        controlProduct = new ControlProduct("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\product.txt");

    }


    @BeforeEach
    public void preconditie() {
        controlProduct = new ControlProduct("C:\\Users\\Iulia\\Desktop\\WebDev\\TemeOOP\\OnlineShop\\test\\resources\\product.txt");
    }


    //postconditie


    @AfterEach
    public void postcondite() {

        controlProduct.clear();
        controlProduct.save();
    }

    @Test
    public void testAdd() {
        Product product = new Product(1, "Ana",23, "alimente",34);
        Product product1 = new Product(2,"Maria",24, "portocale",45);
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product);
        controlProduct.addProduct(product1);
        controlProduct.addProduct(product2);
        assertEquals(3, controlProduct.size());


    }

    @Test
    public void updateName() {
        Product product = new Product(1, "Ana",23, "alimente",34);
        Product product1 = new Product(2,"Maria",24, "portocale",45);
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product);
        controlProduct.addProduct(product1);
        controlProduct.addProduct(product2);
        controlProduct.updatename(1,"Crina");
        assertEquals("Crina", controlProduct.getbyid(1).getName());

    }



    @Test
    public void updatePrice() {
        Product product = new Product(1, "Ana",23, "alimente",34);
        Product product1 = new Product(2,"Maria",24, "portocale",45);
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product);
        controlProduct.addProduct(product1);
        controlProduct.addProduct(product2);
        for(int i=1;i<4;i++){
            if (controlProduct.getbyid(i).getId()>=0 && controlProduct.getbyid(i).getId()<=2 ){
                controlProduct.updatePrice(i, 45);
            }
        }
        for(int i=1;i<4;i++){
            if (controlProduct.getbyid(i).getId()>=0 && controlProduct.getbyid(i).getId()<=2 ){
                assertEquals(45,controlProduct.getbyid(i).getPrice());
            }
        }
    }
    @Test
    public void updateStock() {
        Product product = new Product(1, "Ana",23, "alimente",34);
        Product product1 = new Product(2,"Maria",24, "portocale",45);
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product);
        controlProduct.addProduct(product1);
        controlProduct.addProduct(product2);
        controlProduct.updateStock(1,44);
        assertEquals(44, controlProduct.getbyid(1).getStock());

    }



    @Test
    public void updateDescripttion() {
        Product product = new Product(1, "Ana",23, "alimente",34);
        Product product1 = new Product(2,"Maria",24, "portocale",45);
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product);
        controlProduct.addProduct(product1);
        controlProduct.addProduct(product2);
        controlProduct.updateDescription(1,"banane");
        assertEquals("banane", controlProduct.getbyid(1).getDescription());
    }

    @Test
    public void testDelete(){
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product2);
        controlProduct.delete(1);
        assertEquals(null,controlProduct.getbyid(1));

    }



    @Test
    public void testtoSavedoi(){
        Product product2 = new Product(3, "Victor",34,"capsuni",44);
        controlProduct.addProduct(product2);
        controlProduct.save();
        controlProduct.load();
        assertEquals("Victor",controlProduct.getbyid(3).getName());
    }
   @Test
    public void testisNume(){
        Product product1=new Product(2,"salata",34,"leguma",45);
        Product product2=new Product(3,"capsuni",45,"fructe",56);
        controlProduct.addProduct(product1);
        controlProduct.addProduct(product2);
        controlProduct.isNume("capsuni");
        assertEquals("capsuni",controlProduct.getbyid(3).getName());
   }

   @Test
    public void testisID(){
        Product product=new Product(2,"salata",34,"leguma",45);
        controlProduct.addProduct(product);
       Product p= controlProduct.product("salata");
        assertEquals(34, p.getPrice());
   }
   @Test
    public void getByid(){
        Product product=new Product(2,"salata",22,"leguma",22);
        controlProduct.addProduct(product);
        controlProduct.getbyid(2);
        assertEquals(2,controlProduct.product("salata").getId());

   }
}