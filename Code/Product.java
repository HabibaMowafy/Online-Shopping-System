import java.util.ArrayList;

/**
 *
 * @author Omar_Mamon
 */

public final class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private double rating;
    public int numberOfRatings = 0;

    public Product(int productId, String name, String description, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.rating = 0;
    }

    // defining setters
    public void setPrice(double price) {
        // to set price of product if changed
        this.price = price;
    }

    public void setQuantity(int quantity) {
        // for setting in/out products
        this.quantity = quantity;
    }

    // defining getters
    public int getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAvailableQuantity() {
        return this.quantity;
    }

    public double getRating() {
        return this.rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    // Exception handling
    public static class ratingExceededException extends Exception {
        public ratingExceededException(String message) {
            super(message);
        }
    }

    public double ratingCalc(int rating) throws ratingExceededException {
        // calculate rating
        if (rating < 0 || rating > 5) {
            throw new ratingExceededException("Invalid rating, rating should be between 0 and 5");

        } else {
            this.rating = (this.rating * this.numberOfRatings + rating) / (numberOfRatings + 1);

            // update the Number of Ratings
            this.numberOfRatings++;

            System.out.println(
                    "Thanks for rating our products your opinion matters us !♥ \n New rating is: " + this.rating);
            return this.rating;
        }
    }

    public ArrayList<String> getDetails() {
        // return all data members
        // Create an ArrayList object to contain all the details

        ArrayList<String> productDetails = new ArrayList<String>();
        productDetails.add(Integer.toString(this.productId));
        productDetails.add(this.name);
        productDetails.add(this.description);
        productDetails.add(Double.toString(this.price));
        productDetails.add(Integer.toString(this.quantity));
        productDetails.add(Double.toString(this.rating));
        productDetails.add(Integer.toString(this.numberOfRatings));

        return productDetails;
    }

    public void addedToCart(int quantity) {
        // product added to cart
        if (this.quantity == 0) {
            System.out.println("Product out of stock");
        } else if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("not enough quantity available");
        }
    }

    public void removedFromCart(int quantity) {
        // product added to cart
        this.quantity += quantity;
    }

}
