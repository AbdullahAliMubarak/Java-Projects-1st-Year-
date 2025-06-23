//Program to find the sum amounts of money
//Abdullah Ali Mubarak ALMABD030
//07/08/2024

import java.util.Scanner;

public class TestSeller{
   public static void main(String[] args){
      Scanner scannerObj = new Scanner(System.in);
      Currency rand = new Currency("R", "ZAR", 100);
     
      System.out.print("Please enter the details of the seller.\n");
     
      System.out.print("ID: ");
      String ID = scannerObj.nextLine();
     
      System.out.print("Name: ");
      String Name = scannerObj.nextLine();
     
      System.out.print("Location: ");
      String Location = scannerObj.nextLine();
     
      System.out.print("Product: ");
      String Product = scannerObj.nextLine();
     
      System.out.print("Price: ");
      String Price = scannerObj.nextLine();
      Money unit_price = new Money(Price, rand);
     
      System.out.print("Units: ");
      int Units = scannerObj.nextInt();
     
      Seller ThisSeller = new Seller(ID,Name,Location,Product,unit_price,Units);
     
      System.out.println("The seller has been successfully created:");
      System.out.println("ID of the seller: " + ThisSeller.ID);
      System.out.println("Name of the seller: "+ThisSeller.Name);
      System.out.println("Location of the seller: "+ThisSeller.Location);
      System.out.println("The product to sell: " + ThisSeller.Product);
      System.out.println("Product unit price: " + ThisSeller.unit_price);
      System.out.println("The number of available units: "+ ThisSeller.number_of_units);
     
   }
}
     
