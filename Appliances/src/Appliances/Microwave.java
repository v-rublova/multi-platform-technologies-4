/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliances;

/**
 *
 * @author v.rublova
 */
public class Microwave extends BasicKitchenThing {
    
    String mode;
    
    public Microwave(){
        super();
        this.mode = "Cake";
        this.model = "Microwave";
    }
    public boolean SetupMode(String m){
        switch(m){
            case "cake":
            case "Cake":{
                this.mode = "Cake";
                return true;
            }
            case "Grill":
            case "grill":{
                this.mode = "Grill";
                return true;
            }
            case "Normal":
            case "normal":{
                this.mode = "Normal";
                return true;
            }
            default:
                return false;
        }
    }
    public String ListModes(){
        return "Grill\nCake\nNormal";
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
