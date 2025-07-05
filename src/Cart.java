import java.util.*;

public class Cart{
    private HashMap<Product,Integer> items=new HashMap<>();
    public boolean Add(Product A,int n){
      if (A.getQuantity()<n&&n<=0){
       throw new IllegalArgumentException("Invalid quantity");
    }
    
    
    items.put(A,n);
    return true;
    }
    public HashMap<Product,Integer> getItems(){
        return items;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }

}
