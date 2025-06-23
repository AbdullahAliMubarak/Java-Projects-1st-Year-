import java.util.Scanner;

public class Question3{
   public static void main(String[] args){
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter the vehicle manufacturer:");
      String make = keyboard.nextLine();
      
      System.out.println("Enter the name of the vehicle owner:");
      String name = keyboard.nextLine();
      
      System.out.println("Enter the owner's gender:");
      String gender = keyboard.nextLine();
      
      System.out.println("Enter the owner's programme of study:");
      String programme = keyboard.nextLine();
      
      System.out.println("Enter the owner's Institution name:");
      String institution = keyboard.nextLine();
      
      System.out.println("Enter the owner's hobbies:");
      String hobbies = keyboard.nextLine();
      
      System.out.println("Enter the owner's age:");
      int age = keyboard.nextInt();
      
      System.out.println("Enter the number of cylinders in the engine:");
      int cylinders = keyboard.nextInt();
      
      System.out.println("Enter the car seating capacity:");
      int seats = keyboard.nextInt();
      
      System.out.println("Enter the weight of the car:");
      double weight = keyboard.nextDouble();
      
      Student newStudent = new Student(name, age, gender, institution, programme, 0, hobbies);
      
      Car newCar = new Car(cylinders, make, newStudent, seats, weight);
      
      System.out.println(newCar);
   }
}