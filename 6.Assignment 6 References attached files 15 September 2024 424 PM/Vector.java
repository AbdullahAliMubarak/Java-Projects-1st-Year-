//construction of a Java class to represent a vector in two dimensions
public class Vector{
   //instance variables
   double compX;
   double compY;
   
   //constructor
   public Vector(double x, double y){
      this.compX = x;
      this.compY = y;
   }
   
   //methods
   
   //obtain x component
   public double x(){
      return this.compX;
   }
   
   //obtain y component
   public double y(){
      return this.compY;
   }
   
   //obtain magnitude
   public double getMagnitude(){
      double magnitude =  Math.sqrt((Math.pow(this.compX, 2) + Math.pow(this.compY, 2)));
      return magnitude;
   }
   
   //add other vector to this vector
   public Vector add(Vector otherVector){
      return new Vector(this.compX+otherVector.x(),this.compY+otherVector.y());
   }
   
   //scalar multiply vector
   public Vector multiply(double multiplier){
      return new Vector(this.x()*multiplier,this.y()*multiplier);
   }
   
   //obtain do product of two vectors
   public double dotProduct(Vector vTwo){
      return (this.compX*vTwo.x()+this.compY*vTwo.y());
   }
   
   @Override
   public String toString() {
      return String.format("v = (%.2f, %.2f)", compX, compY);
   }
}