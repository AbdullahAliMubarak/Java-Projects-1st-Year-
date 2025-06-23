/* Program to create a parent class shape 
 * Abdullah Ali Mubarak
 * 30 Sep 2024
*/
public class Shape{
   
   //instance variables
   private boolean filled;
   private java.lang.String color;
   
   //constructors
   
   public Shape(java.lang.String color, boolean filled){
      this.filled =  filled;
      this.color = color;
   }
   
   public Shape(){
      //default constructor
   }
   

   //methods
   public boolean equals(Shape shape){
      return this.color == shape.color && this.filled == shape.filled;
   }
   
   public boolean isFilled(){
      return this.filled;
   }
   
   public double getArea(){
      return 0.0;
   }
   
   public double getPerimeter(){
      return 0.0;
   }
   
   public String getColor(){
      return this.color;
   }
   
   public void setColor(java.lang.String color){
      this.color = color;
   }
   
   public void setFilled(boolean filled){
      this.filled = filled;
   }
   
   //abstract methods
   @Override
   public String toString(){
      return "Colour: "+this.color+", Filled: "+this.filled;
   }
   
}