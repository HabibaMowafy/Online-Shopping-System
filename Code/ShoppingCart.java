import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Habiba
 */
public class ShoppingCart {
    private List<Product> items;
    private List<Integer> quantities;
    
    public static class QuantityExceededException extends Exception {
        public QuantityExceededException(String message) {
            super(message);
        }
    }

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<Integer>();
    }

    public void addItem(Product product) {
        items.add(product);
        quantities.add(1);
        product.addedToCart(1);
    }

    public void removeItem(Product product) {
        items.remove(product);
        int index = items.indexOf(product);
        quantities.remove(index);
        product.removedFromCart(this.quantities.get(index));
    }
    
    public void Increase(Product product) throws QuantityExceededException {
        int index = items.indexOf(product);
        int quantity = this.quantities.get(index);
        int availableQuantity = product.getAvailableQuantity();
        if (quantity > availableQuantity) {
            throw new QuantityExceededException("Sorry, but this quantity exceeds the available quantity.");
        } else {
            this.quantities.set(index, quantity++);
            product.addedToCart(1);
            
            
        }
    }
    
    public void Decrease(Product product) {
        int index = items.indexOf(product);
        int quantity = this.quantities.get(index);
        if (quantity == 1){
           removeItem(product);
        }else{
            this.quantities.set(index, quantity--);
            product.removedFromCart(1);
        }
    }

    public void clearCart() {
        for(int i = 0; i < items.size(); i++){
           this.items.get(i).removedFromCart(this.quantities.get(i));
        }
        items.clear();
        quantities.clear();
    }

    public void displayCart() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getDetails());
            System.out.println(quantities.get(i));
        }
    }
    
    public double getTotalPrice() {
        double totalPrice = 0;
        for(int i = 0; i < items.size(); i++){
            totalPrice += items.get(i).getPrice();
        }
        System.out.println("Total price: " + totalPrice);
        return totalPrice;
    }
    
    public Order checkout() {
        Order order = new Order(this);
        return order;
    }

}
