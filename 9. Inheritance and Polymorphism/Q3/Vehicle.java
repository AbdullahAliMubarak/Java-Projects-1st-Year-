public class Vehicle{
   //instance variables
   private int numCylinders;
   private String maker;
   private Student owner;
   
   //default constructor
   
   public Vehicle(Vehicle v){
      this.numCylinders = v.numCylinders;
      this.maker = v.maker;
      this.owner = v.owner;
   }
   
   //main constructor
   
   public Vehicle(int numCylinders, String maker, Student owner){
      this.numCylinders = numCylinders;
      this.maker = maker;
      this.owner = new Student(owner);
   }
   
   //toString
   @Override
   public String toString(){
      return maker + ", " + numCylinders + " cylinders, owned by " + owner.getName() + ", a " + 
             owner.getAge() + "-year old " + owner.getGender() + " studying " + owner.getProgramOfStudy() + 
             " at " + owner.getNameOfInstitution() + ". " + owner.getName() + " likes " + owner.getHobbies()+".";
   }
   
}