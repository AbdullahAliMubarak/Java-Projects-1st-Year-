/* Program to create a shape rectangle 
 * Abdullah Ali Mubarak
 * 30 Sep 2024
*/
public class Rectangle extends Shape{
   //instance variables
   private double width;
   private double height;
   
   //constructors
   public Rectangle(){
   //default constructor
   }
   
   public Rectangle(double width, double height){
      this.width = width;
      this.height = height;
   }
   
   public Rectangle(double width, double height, String color, boolean isFilled){
      super(color,isFilled);
      this.width = width;
      this.height = height;
   }
   
   //methods
   public boolean equals(Rectangle r){
      return this.width == r.width && this.height == r.height;
   }
   
   public double getArea(){
      return this.width*this.height;
   }
   
   @Override
   public double getPerimeter(){
      return 2*this.width + 2*this.height;
   }
   
   public double getWidth(){
      return this.width;
   }
   
   public double getHeight(){
      return this.height;
   }
   
   public void setWidth(double width){
      this.width = width;
   }
   
   public void setHeight(double height){
      this.height = height;
   }
   
   @Override
   public String toString(){
      return "Rectangle["+super.toString()+", width="+width+", height=" + height + "]";
   }
}