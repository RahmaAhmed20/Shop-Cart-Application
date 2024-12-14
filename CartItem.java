
package OnlineMarket;

public class CartItem {
    
    private Product p;
    private int quantity;
 
    /* public double totalprice(){
     return this.p.getPrice()* ( (double) this.quantity);
     }
    */
    
    public int getQuantity() {
        return this.quantity;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    
    
}
