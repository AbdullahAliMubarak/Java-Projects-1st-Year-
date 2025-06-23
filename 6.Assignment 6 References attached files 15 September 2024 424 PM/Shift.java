public class Shift{
   private CalendarTime Start;
   private CalendarTime Finish;
   
   public Shift(CalendarTime Start, CalendarTime Finish){
      this.Start = Start;
      this.Finish = Finish;
   }
   
   public CalendarTime finish(){
   // Obtain the start date and time for this shift
      return this.Finish;
   }
   
   public CalendarTime start(){
   // Obtain the end date and time for this shift
      return this.Start;
   }
   
   public Duration length(){
   // Determine whether this shift occurred within the given week
      return this.Finish.subtract(this.Start);
   }
   
   public boolean inWeek(Week w){
   // Obtain the length of this shift
      return (w.includes(this.Start.date()) || w.includes(this.Finish.date()));
   }
   
   public boolean includesDate(Date other){
      return ((Start.date().getDay() == other.getDay()) && (Start.date().getMonth() == other.getMonth()) && (Start.date().getYear() == other.getYear()));
   }
   
   public java.lang.String toString(){
     return (Start+" - "+Finish);
   }
}