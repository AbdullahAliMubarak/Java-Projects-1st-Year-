import java.io.File;
import java.io.FileNotFoundException;
//
import java.util.Scanner;
/**
 * See Assignment II Question II
 *
 * @author Stephan Jamieson
 * @version 26/7/2019
 */
public class MarketPlace1 {
    
    private void MarketPlace() {}
    
    private final static Currency RAND = new Currency("R", "ZAR", 100);
    
    
    // Create an instance of Seller with attributes ID, name, location, product, 
    // unit_price and number_of_units
    private static Seller makeSeller(final String data) {
        final Scanner scanner = new Scanner(data.trim());
        scanner.useDelimiter("\\s*,\\s*");
        
        String thisID = scanner.next();
        String name = scanner.next();
        String location = scanner.next();
        String product = scanner.next();
        String price = scanner.next();
        Money thisPrice = new Money(price, RAND);
        int units = scanner.nextInt();
        
        Seller seller = new Seller(thisID,name,location,product,thisPrice,units);
        
        return seller;
    }
    
    // Read the contents of CSV file into an array.
    // See the Appendix on page 4 of the Assignment sheet.
    private static Seller[] parseFile(final String fileName) throws FileNotFoundException {
        final Scanner inFile = new Scanner(new File(fileName));
        Seller[] sellers = null;
    
        if (inFile.hasNextLine()) {
            sellers = new Seller[Integer.parseInt(inFile.nextLine().trim())];
            for (int index=0; index<sellers.length; index++) {
                sellers[index] = makeSeller(inFile.nextLine());
            }
        }
        inFile.close();
        return sellers;
    }
    //GET FIRST INT
        public static int getFirstDigit(int number) {
        String numberStr = Integer.toString(Math.abs(number)); // Convert the number to a string
        char firstChar = numberStr.charAt(0); // Get the first character
        return Character.getNumericValue(firstChar); // Convert the character back to an integer
    }
    
    public static void main(final String[] args) throws FileNotFoundException {
        final Scanner inKey = new Scanner(System.in);
        System.out.println("Enter the name of a \"Comma Separated Values\" (CSV) file:");
        final Seller[] sellers = parseFile(inKey.nextLine());
        
        Scanner ScannerObj = new Scanner(System.in);
        
        System.out.print("Enter the name of a product:\n");
        String prod_Name = ScannerObj.nextLine();
        
        System.out.print("Enter the number of units required:\n");
        int num_units = ScannerObj.nextInt();
        
        System.out.print("Enter the maximum unit price:\n");
        String this_Price = ScannerObj.next();
        Money userPrice = new Money(this_Price, RAND);
        
        int arrayLength = sellers.length;
        
        if (sellers == null){
            System.out.print("The file contains no seller data.");
            System.exit(0);}
            
        boolean noneFound = true;
        
        for (int i = 0; i <= arrayLength-1; i++){
            int priceAcceptable = (sellers[i].unit_price).compareTo(userPrice);
            priceAcceptable = getFirstDigit(priceAcceptable);
            System.out.println(sellers[i].Product);
            System.out.println(sellers[i].number_of_units);
            System.out.println(sellers[i].unit_price);
            System.out.println(priceAcceptable);

            if ((sellers[i].Product == prod_Name) && (sellers[i].number_of_units >= num_units) && (priceAcceptable >= 0)){
                System.out.println(sellers[i].ID + " : " + sellers[i].Name + " in " + sellers[i].Location + " has " + sellers[i].number_of_units + " " + sellers[i].Product + " for " + sellers[i].unit_price + " each.");
                noneFound = false;
            }
        }
    }
}
