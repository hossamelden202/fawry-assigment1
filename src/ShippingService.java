
import java.util.*;

public class ShippingService {
    public static void ship(List<Shippable> items, Map<Shippable, Integer> counts) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            int qty = counts.get(item);
            double weight = item.getWeight() * qty;
            totalWeight += weight;
            System.out.printf("%dx %s\t%.0fg\n", qty, item.getName(), weight * 1000);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
