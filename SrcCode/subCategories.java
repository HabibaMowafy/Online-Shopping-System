package SrcCode;

import java.util.ArrayList;

/**
 *
 * @author shahd
 */

public class subCategories implements Comparable<subCategories> {
    private String nameOfCategory;
    private String description;
    private ArrayList<Product> products;
    
    public subCategories(){
        
    }

    public subCategories(String nameOfCategory, String description, ArrayList<Product> products) {
        this.nameOfCategory = nameOfCategory;
        this.description = description;
        this.products = products;
    }
    
    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    // to get the description of certain category we need:
    public String getDescription() {
        return description;
    }

    // to set the description of certain category we need :
    public void setDescription(String description) {
        this.description = description;
    }

    // to get the category products
    public ArrayList<Product> getProducts() {
        return products;
    }

    // to handle the exception
    public static class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String wanted) {
            super(wanted);
        }
    }

    // adding methode for the search of certain porduct
    void searchProduct(String nameOfProduct) throws ProductNotFoundException {
        int flag = 0;
        for (int i = 0; i < products.size(); i++) {
            if ((products.get(i).getName()).equals(nameOfProduct)) {
                flag = 1;
                System.out.print(products.get(i).getDetails());
                break;
            }
        }
        if (flag == 0)
            throw new ProductNotFoundException("there is no such product found");
    }

    // to print the detailed information of the list :
    public void printCateroryDetails() {
        System.out.println("the name of category is " + nameOfCategory + " the brief description f the category is "
                + description);
        System.out.println("the products exist in the list and there informations :");
        for (int i = 0; i < products.size(); i++)
            products.get(i).getDetails();
    }

    @Override
    public int compareTo(subCategories o) {
        return 1;
    }
}