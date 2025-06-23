public class Student extends Person{
   
   //instance variables
   
   private String nameOfInstitution;
   private String programOfStudy;
   private int yearOfStudy;
   private String hobbies;

   //main constructor
   
   public Student(String name, int age, String gender, String nameOfInstitution, String programOfStudy, int yearOfStudy, String hobbies){
      super(name, age, gender);
      this.nameOfInstitution = nameOfInstitution;
      this.programOfStudy = programOfStudy;
      this.yearOfStudy = yearOfStudy;
      this.hobbies = hobbies;
   }
   
   //copy constructor
   
   public Student(Student other){
      super(other);  // Call Person's copy constructor
      this.nameOfInstitution = other.getNameOfInstitution();
      this.programOfStudy = other.getProgramOfStudy();
      this.yearOfStudy = other.getYearOfStudy();
      this.hobbies = other.getHobbies();
   }
   
   
   //accessor methods
   public String getNameOfInstitution(){ return nameOfInstitution; }
   
   public String getProgramOfStudy(){ return programOfStudy; }
   
   public int getYearOfStudy(){ return yearOfStudy; }
   
   public String getHobbies(){ return hobbies; }
   
   //set methods
   public void setNameOfInstitution(String n){ this.nameOfInstitution=n; }
   
   public void setProgramOfStudy(String p){ this.programOfStudy=p; }
   
   public void setYearOfStudy(int y){ this.yearOfStudy=y; }
   
   public void setHobbies(String h){ this.hobbies=h; }
   
}