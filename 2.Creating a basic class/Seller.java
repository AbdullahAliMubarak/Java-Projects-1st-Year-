//Program to create a class called seller
//Abdullah Ali Mubarak ALMABD030
//06/08/2024

import java.util.Scanner;

public class Seller{
  
     public String ID;
     public String Name;
     public String Location;
     public String Product;
     public Money unit_price;
     //private Currency rand = new Currency("R", "ZAR", 100);
     //private Moneyunit_price = new Money("R0.00", rand);
     public int number_of_units;
     
     //constructor
     public Seller(String ID, String Name, String Location, String Product, Money unit_price, int number_of_units){
        this.ID = ID;
        this.Name = Name;
        this.Location = Location;
        this.Product = Product;
        this.unit_price = unit_price;
        this.number_of_units = number_of_units;
     }
     
}

   