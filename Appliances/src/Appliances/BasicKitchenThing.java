package Appliances;

/**
 *
 * @author v.rublova
 */
public class BasicKitchenThing extends BasicThing implements KitchenThing {

    short temperature;

    public BasicKitchenThing() {
        super();
    }
    public short DisplayHeat(){
        return this.temperature;
    }

    public boolean IncreaseHeat(byte t) {
        if (this.temperature + t > 320){
            return false;
        }
        else{
            this.temperature += t;
            return true;
        }       
    }

    public boolean LowerHeat(byte t) {
        if (this.temperature - t < 0){
            return false;
        }
        else{
            this.temperature -= t;
            return true;
        } 
    }

    public String ShowRecipes() {
       return "sorry :( this function is out of order.";
    }
}
