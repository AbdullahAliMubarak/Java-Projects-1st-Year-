//Program to create a parking tariff containing duration stayed and amount to be paid
//Abdullah Ali Mubarak ALMABD030
//final edits made on 30/08/24 
public class ParkingTariff {
    private TimePeriod timePeriod;
    private Money cost;

    public ParkingTariff() {
    //set instance variables to null as they have no data passed as parameter
        this.timePeriod = null;
        this.cost = null;
    }

    public ParkingTariff(TimePeriod timePeriod, Money cost) {
        this.timePeriod = timePeriod;
        this.cost = cost;
    }

    public boolean containsDuration(Duration duration) {
    //return true if duration is included in time period
        return timePeriod.includes(duration);
    }

    public Money getCost() {
    //return tariff amount
        return cost;
    }

    public TimePeriod getTimePeriod() {
    //return the period
        return timePeriod;
    }

    public boolean isDirectlyFollowedBy(TimePeriod period) {
    //return true if the time is adjacent to the given period otherwise return false
        return timePeriod.adjacent(period);
    }

    public void setMoney(Money cost) {
    //set cost to given amount
        this.cost = cost;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
    //set time period to given period
        this.timePeriod = timePeriod;
    }

    
    public String toString() {
    //output the parking tariff in the require format
        return timePeriod.toString() + " : " + cost.toString();
    }
}