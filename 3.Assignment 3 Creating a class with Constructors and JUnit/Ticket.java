public class Ticket{
    //Instance variables
    public String id;
    public Time issueTime;
    
    //constructor
    public Ticket(Time time, String ID){
        this.id = ID;
        this.issueTime = time;
    } 
    
    //Obtain string Id
    public String ID(){
        String thisID = this.id;
        return thisID;
    }
    
    //Obtain ticket age i.e. issue time subtracted from given time
    public Duration age(Time currentTime){
        Duration ticketAge;
        ticketAge = currentTime.subtract(this.issueTime);
        return ticketAge;
    }
    
    //obtain ticket in the form Ticket[id="ddddd", time="hh:mm:ss"].
    public String toString(){
        String thisTicket = "Ticket[id="+this.id+", time="+this.issueTime+"]";
        return thisTicket;
    }

}