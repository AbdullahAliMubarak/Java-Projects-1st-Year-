public class CashDispenser{
   //instance variables
   private int CashAvailable;
   private int InitialCashAvailable=50000;
   
   //constructor
   public CashDispenser(){
     this.CashAvailable=this.InitialCashAvailable;
   }
   
   //methods
   //check if the atm has enough cash available for withdrawal
   public boolean isSufficientCashAvailable(double Amount){
      if (this.CashAvailable>Amount){
         return true;
      }
      return false;
   }
   
   //dispense the cash if there is enough cash available
   public void dispenseCash(double Amount){
      if (this.isSufficientCashAvailable(Amount)){
         this.CashAvailable -= Amount;
      }
   }
}