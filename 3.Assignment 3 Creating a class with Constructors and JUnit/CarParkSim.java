import java.util.Scanner;
/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and ...
 * @version 14/7/2019
 */
public class CarParkSim { 
        
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        // YOUR CODE HERE.
        // Declare variables to store a Clock and a Register object, create the relevant objects and assign them. 
        
        Register thisRegister = new Register();
        Clock thisClock = new Clock(new Time("00:00:00"));
        
        System.out.println("Car Park Simulator");
        // YOUR CODE HERE.
        // Print current time.
        System.out.println("The current time is "+thisClock.examine()+".");
        System.out.println("Commands: advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("advance")) {
                // YOUR CODE HERE.
                // Advance the clock, print the current time.
                int minutes = keyboard.nextInt();
                Duration thisDuration = new Duration("minute", minutes);
                thisClock.advance(thisDuration);
                System.out.println("The current time is "+thisClock.examine()+".");
            }
            else if (input.equals("arrive")) {
                // YOUR CODE HERE.
                // Create a new ticket, add it to the register, print details of ticket issued.
                String thisId = UIDGenerator.makeUID();
                Ticket thisTicket = new Ticket(thisClock.examine(), thisId);
                thisRegister.add(thisTicket);
                System.out.print("Ticket issued: "+"Ticket[id="+thisId+", time="+thisClock.examine()+"].\n");
                
            }
            else if (input.equals("depart")) {
                // YOUR CODE HERE.
                // Determine if ticket is valid, i.e. in the register.
                String thisId = keyboard.next().trim();
                if (thisRegister.contains(thisId)){
                    System.out.println("Ticket details: "+thisRegister.retrieve(thisId).toString()+".");
                    
                    Ticket currentTicket = thisRegister.retrieve(thisId);
                    Duration currentDuration = currentTicket.age(thisClock.examine());

                    //int hoursSpent = CurrentTime.getHours() - TimeArrived.getHours();
                    //int minutesSpent = CurrentTime.getMinutes() - TimeArrived.getMinutes();

                    System.out.println("Current time: "+thisClock.examine()+".");
                    System.out.println("Duration of stay: "+Duration.format(currentDuration, TimeUnit.HOUR, TimeUnit.MINUTE)+".");
                // If not, print error message.
                // If yes, retreive it, calculate duration of stay and print it.
            } else { System.out.println("Invalid ticket ID.");}
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: advance <minutes>, arrive, depart, quit.");

            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
