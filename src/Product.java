
import java.time.LocalDate;
import java.util.*;

 interface Shippable{
       double getWeight();
       String getName();
      
}
 public abstract class  Product {

    protected String name;
    protected double price;
    protected int  quantity;
    
    public Product(String name,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void reduceQuantity(int n){
        this.quantity-=n;
    }
    public boolean isExpired(){
        return false;
    }
    public boolean isShippable(){
        return false;
    }
    public double getWeight(){
        return 0;
    } 

}
 class ShippableExpireableProduct extends Product implements Shippable{
    private double weight;
    private LocalDate expireDate;
    public ShippableExpireableProduct(String name,double price,int quantity,double weight,LocalDate expireDate){
       super(name,price,quantity);
        this.weight=weight;
        this.expireDate=expireDate;
    }
    public LocalDate getExpireDate(){
        return expireDate;
    }
    @Override
    public boolean isExpired(){
        return expireDate.isBefore(LocalDate.now());
    }
    @Override
    public boolean isShippable(){
        return true;
    }
    @Override
    public double getWeight(){
        return weight;
    }    
}
class NonExpireableShippableProduct extends Product implements Shippable{
    private double weight;
    public NonExpireableShippableProduct(String name,double price,int quantity,double weight){
       super(name,price,quantity);
        this.weight=weight;
        
    }
  
    @Override
    public boolean isShippable(){
        return true;
    }
    @Override
    public double getWeight(){
        return weight;
    }    

}
 class ExpirableNonShippableProduct extends Product{
     private LocalDate expireDate;
    public ExpirableNonShippableProduct(String name,double price,int quantity,LocalDate expireDate){
       super(name,price,quantity);
      
        this.expireDate=expireDate;
    }
    public LocalDate getExpireDate(){
        return expireDate;
    }
    @Override
    public boolean isExpired(){
        return expireDate.isBefore(LocalDate.now());
    }
    
}
 



