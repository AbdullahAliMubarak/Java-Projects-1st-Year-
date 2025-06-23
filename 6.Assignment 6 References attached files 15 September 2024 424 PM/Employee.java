import java.util.ArrayList;
import java.util.List;
public class Employee{
   private CalendarTime myCalendarTime;
   private java.lang.String Name;
   private java.lang.String id;
   private java.util.List<Shift> myList= new ArrayList<>();
   
   //contstructor
   public Employee(java.lang.String name, java.lang.String id){
      this.Name = name;
      this.id = id;
   }
   
   public Duration hours(Week w){
   // Returns the total time (hours and minutes) worked during the given week
   
      Shift currentShift;
      Duration totalTime = new Duration(0);
      Duration timeDiff;
      
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         //check if the employee worked during required week
         if (currentShift.inWeek(w)){
            //calculate difference in time from start of shift to end
            //Time startTime = currentShift.start().time();
            //Time finishTime = currentShift.finish().time();
            timeDiff = (currentShift.finish().subtract(currentShift.start()));
            totalTime.add(timeDiff);
         }

      }
      return totalTime;
   }
   
   public boolean present(){
   // Determine whether this employee is present ie has signed-in and not yet signed-out
      Shift currentShift;
      boolean present = false;
      //loop through list
      if (myList == null){}
      else {
         for (int i = 0; i < myList.size(); i++){
            currentShift = myList.get(i);
            CalendarTime start = currentShift.start();
            CalendarTime finish = currentShift.finish();
        
         
            //check if finish is empty
            if (currentShift.finish()==null){
               present = true;
               return present;
            }
         
         }
      }
      return present;
   }
   
   
   public boolean present(Date d){
   // Determine whether this employee is present ie has signed-in and not yet signed-out
      Shift currentShift;
      boolean present = false;
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         CalendarTime start = currentShift.start();
         CalendarTime finish = currentShift.finish();
         //check if start or finish has the required date
         if (start.date().equals(d)){
            //check if finish is empty
            if (currentShift.finish().equals(null)){
               present = true;
               return present;
            }
         }
      }
      return present;
   }
   
   public boolean worked(Date d){
   //check if the employee worked on that date
      Shift currentShift;
      boolean worked = false;
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         CalendarTime start = currentShift.start();
         CalendarTime finish = currentShift.finish();
         //check if start or finish has the required date
         if (start.date().equals(d) || finish.date().equals(d)){
            worked = true;
            return worked;
         }
      }
      return worked;
   }
   
   public boolean worked(Week w){
      //check if the employee worked on that week
      Shift currentShift;
      boolean worked = false;
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         CalendarTime start = currentShift.start();
         CalendarTime finish = currentShift.finish();
         //check if start or finish has the required date
         if (currentShift.inWeek(w)){
            worked = true;
            return worked;
         }
      }
      return worked;
   }
   
   public java.lang.String UID(){
   // Obtain this Employee ID
      return this.id;
   }
   
   public java.lang.String name(){
   // Obtain this employee name
      return this.Name;
   }
   
   public java.util.List<Shift> get(Date d){
   // Obtain a list of the shifts worked by this employee during the given day
      Shift currentShift;
      //create list of type Shift
      java.util.List<Shift> employeeList= new ArrayList<>();
      
      
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         if (currentShift.equals(null)){
            continue;
         } else {
            CalendarTime start = currentShift.start();
            CalendarTime finish = currentShift.finish();
            //check if start or finish has the required date
            if (start.date().equals(d) || finish.date().equals(d)){
               employeeList.add(currentShift);
            }
         }
      }
      
      return employeeList;
   }
   
   public java.util.List<Shift> get(Week w){
      // Obtain a list of the shifts worked by this employee during the given week
      Shift currentShift;
      //create list of type Shift
      java.util.List<Shift> employeeList= new ArrayList<>();
      
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         if (currentShift.equals(null)){
            continue;
         } else {
            CalendarTime start = currentShift.start();
            CalendarTime finish = currentShift.finish();
            //check if start or finish has the required week
            if (currentShift.inWeek(w)){
               employeeList.add(currentShift);
            }
         }
      }
      
      return employeeList;
   }
   
   public void signIn(Date date, Time time){
   // Record that this employee has begun a shift on the given date and at the given time
      CalendarTime myCT = new CalendarTime(date, time);
      Shift myShiftStart = new Shift(myCT, null);
      myList.add(myShiftStart);
   }
   
   public void signOut(Date date, Time time){
   // Record that this employee has completed a shift on the given date and at the given time
      Shift currentShift;
      //loop through list
      for (int i = 0; i < myList.size(); i++){
         currentShift = myList.get(i);
         //check if finish time is null
         if (currentShift.finish() == null){
            CalendarTime myCT = new CalendarTime(date, time);
            Shift completedShift =  new Shift(currentShift.start(), myCT);
            this.myList.set(i, completedShift);
         }
      }
   }
}