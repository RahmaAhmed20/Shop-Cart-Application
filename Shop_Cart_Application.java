
package OnlineMarket;

import java.io.*;
import java.util.Scanner;

public class Shop_Cart_Application {
    public static void main(String[] args) {
        
                           //(ID, Price, Stock)
        Product p1 = new Product(3,50,6);
        p1.setName("vasline");
        Product p2 = new Product(4,60,7);
        p2.setName("nivea cream");
        Product p3 = new Product(5,70,5);
        p3.setName("body splash ");
       
        
        Cart cart = new Cart(); 
        
        //put products into catalog
        //intialize stocks hashmap
        ShopManager c = new ShopManager();
        c.setCatalog(p1);
        c.setStocks(p1);
        c.setCatalog(p2);
        c.setStocks(p2);
        c.setCatalog(p3);
        c.setStocks(p3);
  
   //     System.out.println("the stock of p2 is = " +c.getStocks(p2));
   //     c.updateStock(p2, 2);
   //     System.out.println("the stock of p2 is = " +c.getStocks(p2));

        
        
        Scanner scanner = new Scanner(System.in);
      
        //flag to exit the loop when user input = 7
        int toExit =1; 
        while(toExit != 7 ){
            
        try{
        System.out.println("1. View Catalog\n" +
"2. Add to Cart\n" +
"3. Remove from Cart\n" +
"4. View Cart\n" +
"5. Save Cart to File\n" +
"6. Load Cart from File\n" +
"7. Exit\n" +
"Choose an option:");
        
        
    Scanner scan = new Scanner(System.in);  
    int chose = scan.nextInt();

        switch (chose) {
            case 1:
                c.showCatalog();
                break;
            case 2:
                System.out.println("Enter the product id and the quantity");
             //   Scanner scan2 = new Scanner(System.in);  
                int ID = scan.nextInt();
             //   Scanner scan3 = new Scanner(System.in);  
                int quant = scan.nextInt();
                cart.addItem(c.search(ID), quant);
                cart.calculateTotal();
                
                break;
            case 3:
                System.out.println("Enter the product id and the quantity you want to delete");
            //    Scanner scan4 = new Scanner(System.in);  
                int ID2 = scan.nextInt();
             //   Scanner scan5 = new Scanner(System.in);  
                int quant2 = scan.nextInt();
                cart.removeItem(c.search(ID2), quant2);
                
                break;
            case 4:
                cart.showCart();
                break;
            case 5:
                cart.saveCart();
                break;
            case 6:
                cart.readCart();
                break;
            case 7:
                toExit =7;
                break;
            default:
                System.out.println("Try again.");
                break;
        
    }}catch(Exception e){
    e.getMessage();
            System.out.println("Try again.");
}
        }
    
    }
}
