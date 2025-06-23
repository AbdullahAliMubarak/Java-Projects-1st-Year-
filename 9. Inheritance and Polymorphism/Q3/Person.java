/**
Creating a person parent class
Abdullah Ali Mubarak
ALMABD030
*/
public class Person{
   //instance variables
   
   private String name;
   private int age;
   private String gender;
   
   //default constructor
   
   public Person(Person p){
      this.name = p.getName();
      this.age = p.getAge();
      this.gender = p.getGender();
   }
   
   //main constructor
   
   public Person(String name, int age, String gender){
      this.name = name;
      this.age = age;
      this.gender = gender;
   }
   
   //set methods
      
   public void setName(String name){ this.name = name; }
   
   public void setAge(int age){ this.age = age; }
   
   public void setGender(String gender){ this.gender = gender; }
   
   //accessor methods
   
   public String getName(){ return name; }
   
   public int getAge(){ return age; }
   
   public String getGender(){ return gender; }
   

}