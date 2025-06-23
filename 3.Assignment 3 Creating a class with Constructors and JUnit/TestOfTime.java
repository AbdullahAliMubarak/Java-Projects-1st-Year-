import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestOfTime {

   @Before public void setUp() {
   }
   
   @Test public void is_val_stored() {
       Time t1 = new Time("10:05:30");
       String timeStored = t1.toString();
       
       Assert.assertEquals("Check if Time Object stores time value","10:05:30",timeStored);
       }

   @Test public void test_subtract1() {
       Time t1 = new Time("09:00:00");
       Time t2 = new Time("09:01:00");
       Duration timeDifference = t2.subtract(t1);
       
       Assert.assertEquals("Check to see if 9:00 to 9:01 returns correct duration",1,timeDifference.intValue("minutes"));
       
   }

    @Test public void test_subtract2() {
        Time t1 = new Time("07:35:00");
       
        Duration ThisTimeDifference = t1.subtract(t1);
        Assert.assertEquals("Check to see if subtracting a time from itself gives a duration of 0",ThisTimeDifference.intValue("minute"),0);
    } 

    @Test public void test_inValue_millisecond()  {
        Time t1 = new Time("12:00:00");
        Time t2 = new Time("12:01:00");
       
        Duration ThisTimeDifference = t2.subtract(t1); 
        Assert.assertEquals("Check to see if intValue method works with parameter \"millisecond\"",60000,ThisTimeDifference.intValue("millisecond"));
       }
       

    @Test public void test_inValue_second()  {
        Time t1 = new Time("12:00:00");
        Time t2 = new Time("12:01:00");
       
        Duration ThisTimeDifference = t2.subtract(t1); 
        Assert.assertEquals("Check to see if intValue method works with parameter \"second\"",60,ThisTimeDifference.intValue("second"));
       }
   
   
    @Test public void test_inValue_minute()  {
        Time t1 = new Time("12:00:00");
        Time t2 = new Time("12:01:00");
       
        Duration ThisTimeDifference = t2.subtract(t1); 
        Assert.assertEquals("Check to see if intValue method works with parameter \"minute\"",1,ThisTimeDifference.intValue("minute"));
       }  

    @Test public void test_inValue_hour()  {
        Time t1 = new Time("13:00:00");
        Time t2 = new Time("14:00:00");
       
        Duration ThisTimeDifference = t2.subtract(t1); 
        Assert.assertEquals("Check to see if intValue method works with parameter \"hour\"",1,ThisTimeDifference.intValue("hour"));
       }     
}
