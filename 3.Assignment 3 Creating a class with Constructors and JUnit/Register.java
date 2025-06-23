public class Register{
    
    //instance variables
    Ticket[] tickets;
    int numTickets;
    
    //Constructors
    public Register(){
        this.tickets = new Ticket[100];
        int numTickets = 0;
    }
    
    //store ticket in register
    public void add(Ticket ticket){
        //store ticket in next free element in tickets array
        this.tickets[numTickets] = ticket;
        //increment number of tickets by 1
        this.numTickets=this.numTickets+1;
    }
    
    public boolean contains(String ticketID){
        int ArrayLen = this.tickets.length;
        boolean found = false;
        int index = 0;   
        //find whether given ticket id exists in register 
        while (!found && index < this.numTickets){
            if (this.tickets[index] != null){
                if (this.tickets[index].ID().equals(ticketID)){
                found = true;} else { index=index+1; }
            } else{ index=index+1; }
        }
        return found;
    }
    
    public Ticket retrieve(String ticketID){
        // Get the Ticket with the given ID from the collection.
        if (this.contains(ticketID)){
        boolean found = false;
        int index = 0;
        int ArrayLen = this.tickets.length;
        while (!found && index < numTickets){
            if (this.tickets[index] != null && this.tickets[index].ID().equals((ticketID))){
                found = true;
                return this.tickets[index];
            } else{ index++; 
            }
        }
        
    }return null;
  }
}