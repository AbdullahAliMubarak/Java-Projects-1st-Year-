//Program to find the sum amounts of money
//Abdullah Ali Mubarak ALMABD030
//01/08/2024

import java.util.Scanner;

public class SumCosts{
  public static void main(String[] args){
     Scanner scannerObj = new Scanner(System.in);
     Currency rand = new Currency("R", "ZAR", 100);
     Money TotalMoney = new Money("R0.00", rand);
     
    while (true) {
       System.out.print("Enter an amount or '[D]one' to print the sum and quit:\n");
       String userInput = scannerObj.next();  // Read user input
    
       if ((userInput.equals("D"))||(userInput.equals("Done"))) {  // Check if the user input is "D"
           break;  //user is done
    }
    
       Money money = new Money(userInput, rand);  //update money with amount
       TotalMoney = TotalMoney.add(money);  //add total
}
        
      System.out.print("Total: " + TotalMoney.toString());
      
      }
}