import java.time.*;
import java.util.*;

/**
 *
 * @author Nouran
 */

public class Order {
    private List<Product> items;
    private LocalDate OrderDate;
    private LocalDate DeliveryDate;
    private ShoppingCart shoppingcart;
    double TotalPrice_afterDiscount;
    ShoppingCart item = new ShoppingCart();

    public Order(ShoppingCart shoppingcart){
        this.shoppingcart = shoppingcart;
    }

    public Order(List<Product> items, LocalDate orderDate){
        this.items = items;
        this.OrderDate = orderDate;
    }

//--------setters and getters--------//

    public LocalDate getOrderDate(){
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate){
        this.OrderDate = orderDate;
    }

    public LocalDate getDeliveryDate(){
        return (DeliveryDate = OrderDate.plusDays(7));
    }

// ------------Methods-----------//

    public void Display_Date(){
        System.out.println("Your order will arrive after 7 days");
        System.out.println("OrderDate : " + getOrderDate());
        System.out.println("DeliveryDate : " + getDeliveryDate());
    }

    public void PriceAfterDiscount(int percent){
        TotalPrice_afterDiscount = item.getTotalPrice();
        TotalPrice_afterDiscount = TotalPrice_afterDiscount - TotalPrice_afterDiscount * percent;
        System.out.println("Total price after discount = " + TotalPrice_afterDiscount);
    }

    public void CancelOrder(){
        items.clear();
        System.out.println("Order canceled. All items removed from the order.");
    }

    public void pay(String PaymentType){
        if ("cash".equalsIgnoreCase(PaymentType)){
                System.out.println("Payment in CASH " + TotalPrice_afterDiscount + "$");
        } else if ("credit".equalsIgnoreCase(PaymentType)){
                System.out.println("Payment in CREDIT " + TotalPrice_afterDiscount + "$");
        } else {
                System.out.println("Invalid payment Please Try again");
        }
    }

    public void isDelivered(){
            try {
                    LocalDate currentDate = LocalDate.now();
                    if (currentDate.isAfter(DeliveryDate)) {
                            System.out.println("Order is delivered");
                    } else {
                            if (currentDate.isBefore(DeliveryDate))
                                System.out.println("Order is not delivered : Pending");
                    }
            } catch (Exception e){
                    System.out.println("Error checking delivery status: " + e.getMessage());
            }
    }
}
