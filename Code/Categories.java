/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;

/**
 *
 * @author shahd
 */

public class Categories implements Comparable<Categories>{
 


    private String nameOfCategory;
  private String description;
    private ArrayList<Product> products; 
  private  double  sellingRate;

    public Categories(String nameOfCategory, String description, ArrayList<Product> products) {
        this.nameOfCategory = nameOfCategory;
        this.description = description;
        this.products = products;
    }
  
   public void setsellingRate(){
  int sum=0; 
   for(int i=0;i<products.size();i++)
   sum+=(products.get(i).getQuantity());
   sum=sum/products.size();
   sellingRate=sum;
   }

   

    public double getSellingRate() {
        return sellingRate;
    }

  
    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }
// to get the s]description of certain category we need:
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
// to get the priority of the 
   
    //the seller will have to remove certain products in the category
  // to add new product by the seller
  public void addNewProduct(Product Newproduct){
      products.add(Newproduct);
  
  }
 // to handle the exception
    public static class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String wanted ) {
            super(wanted);
        }
    }
    
// for removing certain product :)
  public void removeProduct(Product Removedproduct) throws ProductNotFoundException
          { // first we must check whether this product exist in the list or not
              int flag=0;
         for(int i=0;i<products.size();i++)
         {
             if(products.get(i).equals(Removedproduct)) // hint we should override the equal methode in the product class 
         { flag=1;
         break;
         } 
         }
         if(flag==0) 
         
          throw new ProductNotFoundException("this product is not found ");
         
         
         else
         products.remove(Removedproduct);
          }
 //to print the detailed information of the list : 
public void printCateroryDetails (){
System.out.println("the name of category is "+ nameOfCategory+" the brief description f the category is "+description);
System.out.println("the products exist in the list and there informations :");
for(int i=0;i<products.size();i++)

products.get(i).getDetails();

}
    
  @Override
    public int compareTo(Categories o) {
     if (sellingRate==o.getSellingRate()) 
         return 0;
     else if(sellingRate>o.getSellingRate()) return 1;
     else
         return -1;
    }

    
    
    
    
    


}