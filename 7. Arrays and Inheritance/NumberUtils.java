public class NumberUtils{
   //The NumberUtils class contains a collection of routines for working with integers
   
   //Constructors
   private NumberUtils() {}
   // A private, empty-bodied constructor prevents NumberUtil objects from being created
   
   //Methods
   public static int[] toArray(int number){
   // Given a number that is n digits in length, maps the digits to an array length n
    //find length of characters and create array of that length
    String numberString = Integer.toString(number);
    int[] digits = new int[numberString.length()];
    
    //Loop through numberString, convert each character to an integer and add to the array as new element
    for (int i = 0; i < numberString.length(); i++) {
        digits[i] = Character.getNumericValue(numberString.charAt(i));
    }
    
    return digits;
   }
   
   public static int countMatches(int numberA, int numberB){
   // Given two numbers, count the quantity of matching digits those with the same value and
   // position For example, given 39628 and 79324, there are 2 digits in common x9xx2x
   // It is assumed that the numbers are the same length and have no repeating digits
      //use the toArray method for bot in values
      int[] arrayA = toArray(numberA);
      int[] arrayB = toArray(numberB);
      //set count to zero
      int count = 0;
      //loop through both arrays and compare digits in same position
      for (int i=0; i<arrayA.length; i++){
         if (arrayA[i]==arrayB[i]){
            count++;
         }
      }
      
      return count;
   }
   
   public static int countIntersect(int numberA, int numberB){
   // Count the quantity of digits that two numbers have in common regardless of position
      //use the toArray method for bot in values
      int[] arrayA = toArray(numberA);
      int[] arrayB = toArray(numberB);
      //set count to zero
      int count = 0;

      //Loop through each number of numberA
      for (int i = 0; i < arrayA.length; i++) {
          //Loop through each number of numberB
          for (int j = 0; j < arrayB.length; j++) {
              // If a common digit is found, increase the count
              if (arrayA[i] == arrayB[j]) {
                  count++;
                  //Set arrayB[j] to a negative one to avoid counting the same digit twice
                  arrayB[j] = -1;
                  break; //if match is found stop checking further in numberB
              }
          }
       }

    return count;
   }
}