package smarthome;

import java.util.Scanner;
/**
 *
 * @author v.rublova
 */
public class SmartHome {

    static UI interf;
    public static void main(String[] args) {
       interf = new UI();
       Scanner input = new Scanner(System.in);
       interf.Hello();  
       while(true){        
           System.out.println("Selecting operation...");
           interf.Split(input.nextLine());
       }
    }
    
}
