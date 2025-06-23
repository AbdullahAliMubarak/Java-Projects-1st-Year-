/**
*Program to create a basic class shape with name and colour
*Abdullah Ali Mubarak 
*ALMABD030
*/
class Shape {
   //instance variables
   private String name;
   private String colour; 
   // Constructor
   public Shape(Shape shape){
   }
    
   public Shape(String name, String color) {
       this.name = name;
       this.colour = color;
   }
    
    

   //output only shape and colour
   @Override
   public String toString() {
       return name + " " + colour;
   }
}