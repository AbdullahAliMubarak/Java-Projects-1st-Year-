/**
Program to create screen class for question 1
Abdullah Ali Mubarak (ALMABD030)
16-10-2024
*/

public class Screen{
   //instance variables
   private String serialNum;
   private String manufacturer;
   private String colour;
   private String size;
   
   //default constructor
   public Screen(){}
   
   //methods
   public void setSerialNum(String s){ this.serialNum = s; }
   
   public void setManufacturer(String m){ this.manufacturer = m; }
   
   public void setColour(String c){ this.colour = c; }
   
   public void setSize(String s){ this.size = s; }
   
   public String getSerialNumber(){ return this.serialNum; }
   
   @Override
   public String toString(){ return "Screen: "+ serialNum + ", " + colour + ", "  + manufacturer +  ", " + size; }
}