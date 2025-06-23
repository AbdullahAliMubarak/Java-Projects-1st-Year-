/**
Program for user interface on question 1
Abdullah Ali Mubarak (ALMABD030)
16-10-2024
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Question1{
   public static void main(String[] args){
      
      ArrayList<Object> partList = new ArrayList<>();
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Welcome to Great International Technology\n"
                       + "MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
      String option = keyboard.nextLine().toLowerCase();
      
      while (!option.equals("q")){
         if (option.equals("b")){
         
            Box newBox = new Box();
            //get serial number
            System.out.println("Enter the serial number");
            newBox.setSerialNum(keyboard.nextLine());
            //get manufacturer name
            System.out.println("Enter the manufacturer");
            newBox.setManufacturer(keyboard.nextLine());
            //get colour
            System.out.println("Enter the colour");
            newBox.setColour(keyboard.nextLine());
            //get memory amount
            System.out.println("Enter the amount of memory (MB)");
            newBox.setMemAmount(keyboard.nextLine());
            //add to list
            partList.add(newBox);
            System.out.println("Done");
            
         }else if (option.equals("s")){
         
            Screen newScreen = new Screen();
            //get serial number
            System.out.println("Enter the serial number");
            newScreen.setSerialNum(keyboard.nextLine());
            //get manufacturer name
            System.out.println("Enter the manufacturer");
            newScreen.setManufacturer(keyboard.nextLine());
            //get colour
            System.out.println("Enter the colour");
            newScreen.setColour(keyboard.nextLine());
            //get screen size
            System.out.println("Enter the screen size in inches");
            newScreen.setSize(keyboard.nextLine());
            //add to list
            partList.add(newScreen);
            System.out.println("Done");
            
         }else if (option.equals("a")){
         
            Accessory newAccessory = new Accessory();
            //get serial number
            System.out.println("Enter the serial number");
            newAccessory.setSerialNum(keyboard.nextLine());
            //get manufacturer name
            System.out.println("Enter the manufacturer");
            newAccessory.setManufacturer(keyboard.nextLine());
            //get colour
            System.out.println("Enter the colour");
            newAccessory.setColour(keyboard.nextLine());
            //add to list
            partList.add(newAccessory);
            System.out.println("Done");
            
         }else if (option.equals("d")){
            System.out.println("Enter the serial number");
            String SN = keyboard.nextLine();
            boolean found = false;
            int index = 0;
            
            while (index < partList.size() && !found) {
               Object part = partList.get(index);
               String thisSN = "";
                
               if (part instanceof Box) {
                  thisSN = ((Box) part).getSerialNumber();
               } else if (part instanceof Screen) {
                  thisSN = ((Screen) part).getSerialNumber();
               } else if (part instanceof Accessory) {
                  thisSN = ((Accessory) part).getSerialNumber();
               }
                
                if (SN.equals(thisSN)) {
                    partList.remove(index);
                    found = true;
                    
                } else {
                    index++;
                }
            }
            
            if (!found) {
                System.out.println("Not found");
            } else { System.out.println("Done");} 
            
            
         } else if (option.equals("l")){
            if (partList.isEmpty()) {
                
            } else {
                for (int i = 0; i < partList.size(); i++) {
                    System.out.println(partList.get(i));
                }
            }
            System.out.println("Done");
         }

         
         System.out.println("MENU: add (B)ox, add (S)creen, add (A)ccessories, (D)elete, (L)ist, (Q)uit");
         option = keyboard.nextLine().toLowerCase();
      }
      
      keyboard.close();
   }
}