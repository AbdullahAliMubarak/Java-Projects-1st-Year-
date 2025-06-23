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
public class MarketPlace {
    
    private MarketPlace() {}
    
    private final static Currency RAND = new Currency("R", "ZAR", 100);
    
    
    // Create an instance of Seller with attributes ID, name, location, product, 
    // unit_price and number_of_units
    private static Seller makeSeller(final String data) {
        final Scanner scanner = new Scanner(data.trim());
        scanner.useDelimiter("\\s*,\\s*");
        
        // Add your code here
        //create new seller        
        //store seller data
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
    
    public static void main(final String[] args) throws FileNotFoundException {
        final Scanner inKey = new Scanner(System.in);
        System.out.println("Enter the name of a \"Comma Separated Values\" (CSV) file:");
        final Seller[] sellers = parseFile(inKey.nextLine());
        
        // Your Code here
        boolean noneFound = true;
        if (sellers == null || sellers.length == 0){
            System.out.println("The file contains no seller data.");
        }
        else{
        //get product name
        System.out.println("Enter the name of a product:");
        String productName = inKey.nextLine();
        //get number of units
        System.out.println("Enter the number of units required:");
        int num_Units = inKey.nextInt();
        //get max price user is willing to pay
        System.out.println("Enter the maximum unit price:");
        Money userPrice = new Money(inKey.next(), RAND);

        for (int index = 0; sellers.length > index; index++){
            if (sellers[index].Product.equals(productName) && num_Units <= sellers[index].number_of_units && (sellers[index].unit_price.compareTo(userPrice) <= 0)) {
                System.out.println(sellers[index].ID + " : " + sellers[index].Name + " in " + sellers[index].Location + " has " + sellers[index].number_of_units + " " + sellers[index].Product + " for " + sellers[index].unit_price + " each.");
                noneFound = false;
            }
            }
        if (noneFound == true) {
            System.out.println("None found.");
                    }
            }
    }
}