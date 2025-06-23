//Program to find the difference in minutes between 2 times entered
//Abdullah Ali Mubarak ALMABD030
//01/08/2024

import java.util.Scanner;

public class CalculateDuration{
  public static void main(String[] args){
     
     Scanner scannerObj = new Scanner(System.in);
     
     System.out.print("Enter time A:\n");
     String timeA = scannerObj.next();
     
     System.out.print("Enter time B:\n");
     String timeB = scannerObj.next();
     
     Time TimeA = new Time(timeA);
     Time TimeB = new Time(timeB);
     
     Duration ThisTimeDifference = TimeB.subtract(TimeA);
     
     System.out.println("The time " + timeB + " occurs " + ThisTimeDifference.intValue("minute") + " minutes " + "after the time " + timeA + ".");
     
     scannerObj.close();
     }
}
