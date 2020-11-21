package smarthome;

import java.util.Scanner;
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
       Scanner input = new Scanner(System.in);
       interf.Hello();  
       while(true){        
           System.out.println("Selecting operation...");
           interf.Split(input.nextLine());
       }
    }
    
}
