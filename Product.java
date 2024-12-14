
package OnlineMarket;


public class Product {
    
    private int id ;
    private String name;
    private double price;
    private int stock ;
    
    

    public Product(int i,double p, int s) {
        
        this.id=i;
        this.price=p;
        this.stock=s;
    }
    
    public Product() {
     }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public  int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }
    
  
    
}
