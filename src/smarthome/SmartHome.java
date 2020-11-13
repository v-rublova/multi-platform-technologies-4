package smarthome;

import java.util.Scanner;
import Appliances.UI;
/**
 *
 * @author v.rublova
 */
public class SmartHome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UI interf = new UI();
       Scanner input = new Scanner(System.in);  // Create a Scanner object
       interf.Hello();  
       while(true){        
           interf.Split(input.nextLine());
       }
    }
    
}
