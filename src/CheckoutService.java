
import java.util.*;



public class CheckoutService {
    private static final double SHIPPING_COST_PER_KG = 30;
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double subtotal = 0;
        double totalWeight = 0;
        List<Shippable> shippingList = new ArrayList<>();
        Map<Shippable, Integer> shipCounts = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            if (product.isExpired()) {
                System.out.println("Product " + product.getName() + " is expired.");
                return;
            }
            if (product.getQuantity() < qty) {
                System.out.println("Product " + product.getName() + " is out of stock.");
                return;
            }
            subtotal += product.getPrice() * qty;

            if (product.isShippable() && product instanceof Shippable) {
                Shippable ship = (Shippable) product;
                shippingList.add(ship);
                shipCounts.put(ship, qty);
                totalWeight += ship.getWeight() * qty;
            }
        }
        double shippingFee = totalWeight > 0 ? SHIPPING_COST_PER_KG : 0;
        double total = subtotal + shippingFee;
        if (customer.getBalance() < total) {
            System.out.println("Insufficient balance.");
            return;
        }
        if (!shippingList.isEmpty()) {
            ShippingService.ship(shippingList, shipCounts);
        }
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }
        customer.Buy(total);
        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.printf("%dx %s\t%.0f\n", entry.getValue(), entry.getKey().getName(), entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shippingFee);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Remaining\t%.0f\n", customer.getBalance());
    }
}
