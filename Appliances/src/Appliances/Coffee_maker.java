package Appliances;

/**
 *
 * @author v.rublova
 */
public class Coffee_maker extends BasicKitchenThing {
    
    String mode;
    
    public Coffee_maker(){
        super();
        this.mode = "espresso";
        this.model = "Cofee maker";
    }
    public boolean SetupMode(String m){
        switch(m){
            case "espresso":
            case "Espresso":{
                this.mode = "Espresso";
                return true;
            }
            case "mocca":
            case "Mocca":{
                this.mode = "Mocca";
                return true;
            }
            case "latte":
            case "Latte":{
                this.mode = "Latte";
                return true;
            }
            default:
                return false;
        }
    }
    public String ListModes(){
        return "Espresso\nMocca\nLatte";
    }
    @Override
    public String DisplayAll(){
        return super.DisplayAll()+"\nMode: "+this.mode;
    }

    @Override
    public String DisplayAllOperations() {
        return super.DisplayAllOperations() + "dispm - dispay aviable modes;\nsmode - set preferable mode;"; 
    }
    
    
}
