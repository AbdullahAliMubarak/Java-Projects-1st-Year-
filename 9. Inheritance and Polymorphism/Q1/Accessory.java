/**
Program to create accessory class for question 1
Abdullah Ali Mubarak (ALMABD030)
16-10-2024
*/

public class Accessory{
   //instance variables
   private String serialNum;
   private String manufacturer;
   private String colour;
   
   //default constructor
   public Accessory(){}
   
   //methods
   public void setSerialNum(String s){ this.serialNum = s; }
   
   public void setManufacturer(String m){ this.manufacturer = m; }
   
   public void setColour(String c){ this.colour = c; }
   
   public String getSerialNumber(){ return this.serialNum; }
   
   @Override
   public String toString(){ return "Accessories: "+ serialNum + ", " + manufacturer + ", " + colour; }

}