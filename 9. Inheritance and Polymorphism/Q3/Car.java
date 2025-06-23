public class Car extends Vehicle{
   //instance variables
   private int passengers;
   private double carWeight;
   
   //main constructor
   public Car(int numCylinders, String maker, Student owner, int passengers, double carWeight){
      super(numCylinders, maker, owner);
      this.passengers = passengers;
      this.carWeight = carWeight;
   }
   
   //copy constructor
   public Car(Car c){
      super(c);  // Call Vehicle's copy constructor first
      this.passengers = c.passengers;    
      this.carWeight = c.carWeight;   
   }
   
   //toString
   @Override
   public String toString(){
      return super.toString() + "\nThe car is a " + passengers + "-seater weighing " + carWeight + " kg";
   }
}