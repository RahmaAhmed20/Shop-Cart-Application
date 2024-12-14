
package OnlineMarket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cart  {
    
        List<CartItem> item = new ArrayList<>();
        ShopManager s =new ShopManager();

        
        //check if the product is in stock
        //if the stock of the product is less than quantity it will display msg. "There is only #of stocks of the product"
        //if there is no product in the stock it will display msg. "Out of stock"
        void addItem(Product p, int quantity){
            CartItem cart = new CartItem();
             if( s.getStocks(p) == 0 ){
             System.out.println("Out of stock");
             }else if(s.getStocks(p) < quantity ){
             System.out.println("There is only "+s.getStocks(p)+" of the product");
             }else{    
            cart.setP(p);
            cart.setQuantity(quantity);
            item.add(cart);
            System.out.println("Item added succesfully");
            s.updateStock(p, quantity);
        }
    }
        
    /*    
        void addItem(Product p, int quantity){
             CartItem cart = new CartItem();
             if(p.getStock() < quantity || p.getStock() <= 0){
             System.out.println("Out of stock");
             }else{    
            cart.setP(p);
            cart.setQuantity(quantity);
            item.add(cart);
            System.out.println("Item added succesfully");
            p.updateStock(quantity);

             }
        }
      */      
             
        public void showCart(){
            System.out.println("cart : ");
            for(int i=0; i<item.size() ;i++){
                 for(int j=0; j< item.get(i).getQuantity();j++){
                System.out.println(item.get(i).getP().getName()+"   "+item.get(i).getP().getPrice()+" $");
                        }
                 }        
        }
        
        
        //search product in item arraylist "cart" by id and remove it
        //if user enter an id product that does not exist in cart, it will display "Item does not exist, Try again." 
        public void removeItem(Product p, int quantity){
           
              CartItem cart = new CartItem();
              int flag =0 ;
            for(int i=0; i<item.size();i++){
                if(item.get(i).getP().getId() == p.getId()){
                    item.get(i).setQuantity( (item.get(i).getQuantity()) -  quantity );
                    flag =1;
                    if(item.get(i).getQuantity() == 1){
                        cart.setP(p);
                        cart.setQuantity(quantity);
                        item.remove(cart);              
                        flag =1;
                    }
                    s.updateStockRemove(p, quantity);
                    System.out.println("Item removed succesfully");
                }
            }
            if (flag == 0 ){
                System.out.println("Item does not exist, Try again.");    
            }
        }
          /*
            int newQ =0;
             for(int i=0; i<item.size();i++){
                 if (item.get(i).getP() == p){
                 newQ = ( item.get(i).getQuantity() ) - quantity ;
                  item.get(i).setQuantity(newQ);
                 }
            }
        }     
       */ 
        
        
       public void calculateTotal(){
        double total =0 , sum =0 ;
        for(int i=0; i<item.size();i++){
            total = (item.get(i).getP().getPrice()) * (item.get(i).getQuantity()) ;
            sum = total + sum;
        }
            System.out.println("Total price = " + sum );
        }
    
       
       //save cart into SaveCart.txt 
       public void saveCart(){       
            for(int i=0; i<item.size() ;i++){
                 for(int j=0; j< item.get(i).getQuantity();j++){
                     String s;
                     s = (item.get(i).getP().getName()+"   "+item.get(i).getP().getPrice()+" $");
                     try (BufferedWriter writer = new BufferedWriter(new FileWriter("SaveCart.txt", true))) {
                      writer.write(s);
                      writer.newLine();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                        }
                 }        
       }
       
 
        //read cart from SaveCart.txt 
       public void readCart(){
         try (BufferedReader reader = new BufferedReader(new FileReader("SaveCart.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
       
       
}