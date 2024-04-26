package SrcCode;

/**
 *
 * @author Nouran
 */

import java.time.*;
import java.util.*;

public class Order {
    
    private LocalDate OrderDate;
    private LocalDate DeliveryDate;
    private ShoppingCart shoppingCart;
    double TotalPrice_afterDiscount;
    int creditno;
    ShoppingCart item = new ShoppingCart();

    public Order(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Order(List<Product> items, LocalDate orderDate) {
        items = shoppingCart.getItems();
        this.OrderDate = orderDate;
    }

    // --------setters and getters--------//

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.OrderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return (DeliveryDate = OrderDate.plusDays(7));
    }

    // ------------Methods-----------//

    public void Display_Date() {
        System.out.println("Your order will arrive after 7 days");
        System.out.println("OrderDate : " + getOrderDate());
        System.out.println("DeliveryDate : " + getDeliveryDate());
    }

    public void PriceAfterDiscount(int percent) {
        TotalPrice_afterDiscount = item.getTotalPrice();
        TotalPrice_afterDiscount = TotalPrice_afterDiscount - TotalPrice_afterDiscount * percent;
        System.out.println("Total price after discount = " + TotalPrice_afterDiscount);
    }

    public void CancelOrder() {
        shoppingCart.getItems().clear();
        System.out.println("Order canceled. All items removed from the order.");
    }

    public void pay(String PaymentType) {
        if ("cash".equalsIgnoreCase(PaymentType)) {
            System.out.println("Payment in CASH " + TotalPrice_afterDiscount + "$");
        } else if ("credit".equalsIgnoreCase(PaymentType)) {
        	Scanner input = new Scanner(System.in);
        	try {  
        		creditno = input.nextInt();
                	if(creditno==16)
                    System.out.println("Payment in CREDIT " + TotalPrice_afterDiscount + "$");
                	else throw new 	IllegalArgumentException("Credit number not valid ");  
               }
        	
        	catch(InputMismatchException  e) {
        		System.out.println("must be number");
        	}
        	catch(IllegalArgumentException e) {
        		System.out.println("must be 16 digits");
        	}
    }
    }

    public void isDelivered() {
        try {
            LocalDate currentDate = LocalDate.now();
            if (currentDate.isAfter(DeliveryDate)) {
                System.out.println("Order is delivered");
            } else {
                if (currentDate.isBefore(DeliveryDate))
                    System.out.println("Order is not delivered : Pending");
            }
        } catch (Exception e) {
            System.out.println("Error checking delivery status: " + e.getMessage());
        }
    }
    
}
