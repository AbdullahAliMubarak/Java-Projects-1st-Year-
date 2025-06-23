//program to create a table or array of tariffs for reference when charging the user for parking 
//Abdullah Ali Mubarak ALMABD030
//final edits made on 30/08/24 
public class TariffTable {
    private ParkingTariff[] parkingTariffs;
    private int nextFree;

    public TariffTable(int maxSize) {
        parkingTariffs = new ParkingTariff[maxSize];
        nextFree = 0;
    }

    public void addTariff(TimePeriod period, Money tariff) {
        if (nextFree == 0) {
            // empty, add new tariff
            parkingTariffs[nextFree++] = new ParkingTariff(period, tariff);
        } else {
            // get previous tariff
            TimePeriod prevTariffPeriod = parkingTariffs[nextFree - 1].getTimePeriod();

            // Check if the new period is adjacent or directly follows the last period
            boolean isAdjacent = prevTariffPeriod.adjacent(period);
            boolean isPreceding = prevTariffPeriod.precedes(period);

            // if the times are not adjecent nor does one contain the other then they should not be next to each other
            if (!isAdjacent && !isPreceding) {
                throw new IllegalArgumentException("Tariff periods must be adjacent.");
            }

            //exception not thrown add  new tariff
            parkingTariffs[nextFree++] = new ParkingTariff(period, tariff);
        }
    }

    public Money getTariff(Duration lengthOfStay) {
        for (ParkingTariff tariff : parkingTariffs) { //loop through each element in tariffTable
            if (tariff != null && tariff.containsDuration(lengthOfStay)) { //if not empty and duration is within time period get the payment cost
                return tariff.getCost();
            }
        }
        return null;
    }

    @Override //not obstructed by toString in parkingTariff class
    public String toString() {
        StringBuilder newStringBuilder = new StringBuilder(); //append each tariff in a way such that each appears on a new line like a text file
        for (int i = 0; i < nextFree; i++) {
            newStringBuilder.append(parkingTariffs[i].toString()).append("\n");
        }
        return newStringBuilder.toString().trim();
    }
}

