import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new ShippableExpireableProduct("Cheese", 100, 10, 0.2, LocalDate.now().plusDays(5));
        Product biscuits = new ShippableExpireableProduct("Biscuits", 150, 5, 0.7, LocalDate.now().plusDays(1));
        Product tv = new NonExpireableShippableProduct("TV", 5000, 3, 10);
        Product scratchCard = new Product("Scratch Card", 50, 100) {};

        Customer customer = new Customer("Hossam", 20000);
        Cart cart = new Cart();

        cart.Add(cheese, 2);
        cart.Add(biscuits, 1);
        cart.Add(scratchCard, 1);
        cart.Add(tv, 3);
        //to cover all use cases i added more than the picture in the assigment like tv and scratchcard 
        //i also added reminning balance of custmer to make it more realistic

        CheckoutService.checkout(customer, cart);
    }
}
