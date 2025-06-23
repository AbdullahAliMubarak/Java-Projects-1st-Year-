public class CowsAndBulls {

    public final static int NUM_DIGITS = 4;
    public final static int MAX_VALUE = 9876;
    public final static int MIN_VALUE = 1234;
    public final static int MAX_GUESSES = 10;

    private int secretNumber;
    private int guessesRemaining;
    private int guessNumber;
    private boolean gameOver = false;


    /**
     * Constructor: Create a CowsAndBulls game using the given randomization seed value
     * to generate a mystery number of NUM_DIGITS length, and that gives the player MAX_GUESSES guesses.
     */
    public CowsAndBulls(int seed) {
      NumberPicker random = new NumberPicker(seed,1,9);
      int randomNum = 0;
      for (int i=0; i<this.NUM_DIGITS; i ++){
         if (i == 0){
            randomNum += random.nextInt();
         } else {
            randomNum = randomNum * 10 + random.nextInt();
         }
       }
       
       this.secretNumber = randomNum;
       this.guessesRemaining = this.MAX_GUESSES;
       this.guessNumber = 1111;
     }

    /**
     * Obtain the number of guesses remaining.
     */
    public int guessesRemaining() {
        return guessesRemaining;
    }

    /**
     * Evaluates a guess that the mystery number is guessNumber, returning the outcome in the form
     * of a Result object. Decrements guesses remaining.
     * Assumes that game is not over.
     */
    public Result guess(int guessNumber) {
      this.guessNumber = guessNumber;
      int cows = 0;
      int bulls = 0;
      
      bulls = NumberUtils.countMatches(this.secretNumber, guessNumber);
      cows = NumberUtils.countIntersect(this.secretNumber, guessNumber) - bulls;
       
      if (bulls == 4){
         this.gameOver = true;
      }
      
      if (cows<0) { cows = 0; }
      
      this.guessesRemaining--;
      return new Result(cows,bulls);
    }

    /**
     * Ends the game, returning the secret number.
     */
    public int giveUp() {
      this.guessesRemaining = 0;
      return this.secretNumber;
    }

    /**
     * Returns true if the secret number has been guessed or no guesses are left.
     */
    public boolean gameOver() {
      if (this.gameOver || this.guessesRemaining == 0){
         return true;
      }
      return false;
    }
}
