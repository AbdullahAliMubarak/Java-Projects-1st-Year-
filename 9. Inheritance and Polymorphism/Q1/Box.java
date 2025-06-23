/**
Program to create box class for question 1
Abdullah Ali Mubarak (ALMABD030)
16-10-2024
*/

public class Box{
   //instance variables
   private String serialNum;
   private String manufacturer;
   private String colour;
   private String memAmount;
   
   //default constructor
   public Box(){}
   
   //methods
   public void setSerialNum(String s){ this.serialNum = s; }
   
   public void setManufacturer(String m){ this.manufacturer = m; }
   
   public void setColour(String c){ this.colour = c; }
   
   public void setMemAmount(String a){ this.memAmount = a; }
   
   public String getSerialNumber(){ return this.serialNum; }
   
   @Override
   public String toString(){ return "Box: "+ serialNum + ", " + manufacturer + ", " + colour + ", " + memAmount; }
}