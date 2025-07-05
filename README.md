#  Fawry Rise Internship Challenge 3 – E-commerce System

This is a Java-based implementation of the Fawry Quantum Full Stack Internship Assignment #3.  
It simulates a **mini e-commerce system** with the ability to manage products, handle cart logic, checkout flow, shipping, and customer balances.

---

##  Features Implemented

###  Product Modeling
- Products have: `name`, `price`, `quantity`
- Some products:
  - Can **expire** (like cheese or biscuits)
  - Require **shipping** (like cheese, TV)
  - Are **non-shippable** (like scratch cards)
- Products use **OOP inheritance** and interface composition:
  - `Shippable` interface
  - `Product` abstract class
  - 3 subclasses for different behaviors

---

###  Cart Logic
- Customers can add products to the cart with a valid quantity.
- Cart enforces:
  - No adding more than in-stock quantity
  - No negative or zero quantities
- Cart stores product-quantity mapping using `HashMap<Product, Integer>`

---

### Checkout Flow
- Validates:
  - Cart is not empty
  - No expired products
  - All quantities are in stock
  - Customer has enough balance
- Calculates:
  - Subtotal (sum of all items)
  - Shipping cost (flat fee if at least one item is shippable)
  - Total paid amount
  - **Remaining balance** (added to enhance realism)
- Reduces stock only **after checkout is confirmed**

---

###  Shipping Service
- Collects shippable items and prints a shipment notice:
  - Quantity
  - Weight per item
  - Total package weight
## 🧾 Sample Output

** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
3x TV 30000g
Total package weight 30.1kg
** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Scratch Card 50
3x TV 15000

Subtotal 15400
Shipping 30
---

##  Use Case Enhancements

> //to cover all use cases i added more than the picture in the assignment like tv and scratchcard  
> //i also added remaining balance of customer to make it more realistic

 Added:
- `TV` → Non-expirable but shippable product
- `ScratchCard` → Non-expirable and non-shippable
- Receipt now shows **remaining customer balance after checkout**

---

##  How to Run

### Prerequisites:
- Java 17+ installed

### Folder Structure:
project/
├── src/
│ ├── Main.java
│ ├── Product.java
│ ├── Customer.java
│ ├── Cart.java
│ ├── CheckoutService.java
│ ├── Shippable.java
│ ├── ShippingService.java
│ ├── ExpirableNonShippableProduct.java
│ ├── ShippableExpireableProduct.java
│ └── NonExpireableShippableProduct.java
└── out/

### Compile:
```bash
javac -d out src/*.java
java -cp out Main
##  Sample Output
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
3x TV 30000g
Total package weight 30.1kg
** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Scratch Card 50
3x TV 15000

Subtotal 15400
Shipping 30
Amount 15430
Remaining 4670


