public class Account{

   //instance variables
   private double AvailableBalance;
   private double TotalBalance;
   private int AccountNumber;
   private int Pin;
   
   //constructor
   public Account(int AccountNumber, int Pin, double AvailableBalance, double TotalBalance){
      this.AvailableBalance = AvailableBalance;
      this.TotalBalance = TotalBalance;
      this.AccountNumber = AccountNumber;
      this.Pin = Pin;
   }
   
   //methods
   //validate the pin entered against the stored pin
   public boolean validatePin(int Pin){
      if (this.Pin==Pin){
         return true;
      }
      return false;
   }
   
   //return this clients available balance
   public double getAvailableBalance(){
      return this.AvailableBalance;
   }
   
   //return this clients total balance
   public double getTotalBalance(){
      return this.TotalBalance;
   }
   
   //return this clients account number
   public int getAccountNumber(){
      return this.AccountNumber;
   }
   
   //withdraw amount from accounts available balance
   public void debit(double Amount){
      this.AvailableBalance -= Amount;
      this.TotalBalance -= Amount;
   }
   
   //deposit money to accounts available balance and update total balance
   public void credit(double Amount){
      this.AvailableBalance += Amount;
      this.TotalBalance += Amount;
   }
}