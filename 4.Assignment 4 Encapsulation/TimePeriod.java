//Program to create a duration that has a lowerbound and upperbound for the time period
//Abdullah Ali Mubarak ALMABD030
//final edits made on 30/08/24 
public class TimePeriod{
    
    private Duration lowerBound;
    private Duration upperBound;
    //constructor
    public TimePeriod(Duration lowerBound, Duration upperBound){
        // Create a TimePeriod with the given inclusive lower bound and exclusive upper bound
        this.lowerBound =  lowerBound;
        this.upperBound = upperBound;
    }
    
    //methods
    
    public Duration lowerBound(){
        // Obtain the lower bound for this time period
        return lowerBound;
    }
    
    public Duration upperBound(){
        // Obtain the upper bound for this time period
        return upperBound;
    }
    
    public boolean includes(Duration duration){
        // Determine whether the given duration falls within this time period 
        
        if (duration.compareTo(lowerBound) >= 0 && upperBound.compareTo(duration) > 0){
           return true;
        } else {
        return false;
        }
    }
    
    public boolean precedes(TimePeriod other){
        // Determine whether this time period precedes the other time period 
        //if uppperbound less lowerbound is negative using compareTo method it precedes lowerbound which is not possible
        if (this.upperBound().compareTo(other.lowerBound()) <= 0){
           return true;
        }
        return false;
    }
    
    public boolean adjacent(TimePeriod other){
        // Determine whether this time period is adjacent to the other time period 
        //current durations upper bound must be equal to the next periods lowerbound
        if (this.upperBound.compareTo(other.lowerBound())==0 || this.lowerBound.compareTo(other.upperBound())==0){
            return true;
        }
        return false;
    }
    
    public String toString(){
        
        return String.format("[%s .. %s]", Duration.format(lowerBound, "minute"),  Duration.format(upperBound, "minute"));
    }
}