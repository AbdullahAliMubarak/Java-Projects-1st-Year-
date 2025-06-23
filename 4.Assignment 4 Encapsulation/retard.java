//program to create a table or array of tariffs for reference when charging the user for parking 
//Abdullah Ali Mubarak ALMABD030
//final edits made on 30/08/24 
public class TariffTable{
    
    private ParkingTariff[] parkingTariffs;
    private int nextFree;
    
    //constructor
    public TariffTable(int maxSize){
        //Create a TariffTable with the given maximum number of entries.
        //set next available index to zero
        parkingTariffs = new ParkingTariff[maxSize];
        nextFree=0;
    }
    
    //methods
    
    public void addTariff(TimePeriod period, Money tariff){
        // Add the tariff for the given period to the table. The period must directly follow, and be
        // adjacent to, that for the previous tariff entered.
        // If the period does not follow or is not adjacent then an IllegalArgumentException is thrown.
      
        if (nextFree == 0) {
            // tariff table is empty so just add the new parking tariff
            parkingTariffs[nextFree+1] = new ParkingTariff(period, tariff);
        } else {
            //check if the new period is adjacent to or follows the previous period
            boolean adjacent = parkingTariffs[nextFree - 1].getTimePeriod().adjacent(period);
            boolean precedes = parkingTariffs[nextFree - 1].getTimePeriod().precedes(period);

            if (!adjacent) {
               if (!precedes){
               //if both conditions are false then they are not related and must not be added to the tariff table
                  throw new IllegalArgumentException("Tariff periods must be adjacent.");
               }
            }

            // i the exception is not thrown it is valid
            // add the parking tariff to the table
            parkingTariffs[nextFree++] = new ParkingTariff(period, tariff);
        }
        
    }
    
    public Money getTariff(Duration lengthOfStay){
        // Obtain the tariff for the given length of stay.
        // define durations
        // 30 minutes
        
        for (ParkingTariff currentTariff : parkingTariffs) {//loop through all existing parking tariff elements
        //if element is not empty and element contains the duration of stay return the cost
            if (currentTariff != null && currentTariff.containsDuration(lengthOfStay)) {
                return currentTariff.getCost();
            }
        }
        //if the duration does not exist return null
        return null;

    }
    
    @Override //not obstructed by other tostring method from parking tariff
    public String toString(){
        StringBuilder newStringBuilder = new StringBuilder();
        for (int i = 0; i < nextFree; i++) { //loop through a'' values in tariff table
        //get each parking tariff and append it such that the next will be shown on a new line
            newStringBuilder.append(parkingTariffs[i].toString()).append("\n");
        }
        //remove leading spaces
        return newStringBuilder.toString().trim();
    }
}