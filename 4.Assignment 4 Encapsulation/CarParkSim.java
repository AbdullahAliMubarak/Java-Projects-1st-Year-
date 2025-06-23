import java.util.Scanner;
/**
 * program that operates as an automatic ticket machine that charges for parking based on time spent in the carpark
 *
 * Abdullah Ali Mubarak ALMABD030
 * 30/08/24
 */
public class CarParkSim {

    private CarParkSim() {}

    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        final Clock clock = new Clock(new Time("00:00:00"));
        final Register register = new Register();
        Currency rand = new Currency("R", "ZAR", 100) ; 
        TariffTable tariffTable = new TariffTable(10); //create a tariff table with 10 elements

        // add the given tariffs to the table
        tariffTable.addTariff(new TimePeriod(new Duration("minutes", 0), new Duration("minutes", 30)), new Money("R10", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("minutes", 30), new Duration("hour", 1)), new Money("R15", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 1), new Duration("hour", 3)), new Money("R20", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 3), new Duration("hour", 4)), new Money("R30", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 4), new Duration("hour", 5)), new Money("R40", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 5), new Duration("hour", 6)), new Money("R50", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 6), new Duration("hour", 8)), new Money("R60", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 8), new Duration("hour", 10)), new Money("R70", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 10), new Duration("hour", 12)), new Money("R90", rand));
        tariffTable.addTariff(new TimePeriod(new Duration("hour", 12), new Duration("day", 1)), new Money("R100", rand));
        
        
        System.out.println("Car Park Simulator");
        System.out.printf("The current time is %s.\n", clock.examine());
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();

        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                clock.advance(new Duration("minute", keyboard.nextInt()));
                System.out.printf("The current time is %s.\n", clock.examine());
            } else if (input.equals("arrive")) {
                final Ticket ticket = new Ticket(clock.examine());
                register.add(ticket);
                System.out.printf("Ticket issued: %s.\n", ticket);
            } else if (input.equals("depart")) {
                final String ID = keyboard.next();
                if (!register.contains(ID)) {
                    System.out.println("Invalid ticket ID.");
                } else {
                    final Ticket ticket = register.retrieve(ID);
                    System.out.printf("Ticket details: %s.\n", ticket);
                    System.out.printf("Current time: %s.\n", clock.examine());
                    final Duration durationOfStay = ticket.age(clock.examine());
                    System.out.printf("Duration of stay: %s.\n", Duration.format(durationOfStay, "minute"));

                    // use the ticket duration to find cost of parking
                    Money payment = null;
                    if (tariffTable != null) { //the tariff table must not be empty!!!
                    //get the tariff required for the duration
                        payment = tariffTable.getTariff(durationOfStay);
                    }
                    if (payment == null) {
                    //if there is no cost then cost is just zero
                    //nothing is paid
                        payment = new Money(0, rand);
                    }
                    System.out.printf("Cost of stay : %s.\n", payment);
                }
            } else if (input.equals("tariffs")) {
                if (tariffTable != null) {//table must not be empty!!!
                //display tariffs
                    System.out.println(tariffTable.toString());
                } else {
                //if table is empty let the user know
                    System.out.println("No tariffs available.");
                }
            } else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: tariffs, advance <minutes>, arrive, depart, quit.");
            }
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }
        System.out.println("Goodbye.");
    }
}