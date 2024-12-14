
package OnlineMarket;
import java.util.HashMap;



 public  class ShopManager {
       
    private   HashMap<Integer, Product> catalog = new HashMap<Integer, Product>();
    
           //hashmap to handle stock, hashmap of <id,stcok> of the products 
    static  private   HashMap<Integer, Integer> stocks = new HashMap<Integer, Integer>();
    
     //  private static int i =0;
    /*
     public Product getproduct(int id){

         Product p = new Product();
         for (Product i : catalog.values()) {
   
             if (i.getId() == id){
                 p = i ;
             }
             else{
             p = null;
             }
         }
                      return p;
    }
      */  
    
    

//function to search and get product from catalog by its ID.
    public Product search(int id){
             Product p = new Product();
         for (int i : catalog.keySet()) {
             if(i == id){
                 p.setName(catalog.get(i).getName());
                 p.setPrice(catalog.get(i).getPrice());
                 p.setStock(catalog.get(i).getStock());
                 p.setId(id);
        System.out.println(catalog.get(i).getName());
    }
  }
        return p;
 }
    
    
     public  void setCatalog(Product p) {
    catalog.put(p.getId(), p);
    }
     
     public  void setStocks(Product p) {
    stocks.put(p.getId(), p.getStock());
    }
     
     
     //function to get stock of any product
     public  int getStocks(Product p) {
         int x =0;
               for (int i : stocks.keySet()){
                if( i == p.getId()){
                    x =(stocks.get(i));
                    }
    }
               return  x ;
    } 
     
     
     
     
     //   update stock after adding item
      void updateStock(Product p , int quantity){
          for (int i : stocks.keySet()){
                if( i == p.getId()){
                        stocks.put(p.getId(), (p.getStock() -quantity) );
                    }
    }
   }
        
    //   update stock after removing item
       void updateStockRemove(Product p ,int quantity){
           for (int i : stocks.keySet()){
                if( i == p.getId()){
                        stocks.put(p.getId(), (p.getStock() +quantity) );
                    }
    }    }
     
     
    public   void showCatalog(){
        System.out.println("The Catalog: ");
        for (Product i : catalog.values()) {
        System.out.println("ID." +i.getId()+": "+ i.getName()+"   "+i.getPrice()+"$");
    }
    }
    
    
}
