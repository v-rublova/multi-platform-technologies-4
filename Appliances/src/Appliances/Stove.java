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
public class Stove extends BasicKitchenThing {

    boolean burner_1;
    boolean burner_2;

    public Stove() {
        super();
        this.model = "Stove";
    }

    public void TurnOnBurner_1() {
        burner_1 = true;
    }

    public void TurnOnBurner_2() {
        burner_2 = true;
    }

    public void TurnOffBurner_1() {
        burner_1 = false;
    }

    public void TurnOffBurner_2() {
        burner_2 = false;
    }

    @Override
    public String DisplayAll() {
        String res = super.DisplayAll();
        if (this.burner_1 == true) {
            res += "\nBurner 1: On;\n";
        } else {
            res += "Burner 1: Off;\n";
        }
        if (this.burner_2 == true) {
            res += "Burner 2: On;\n";
        } else {
            res += "Burner 2: Off;";
        }
        return res;
    }

    @Override
    public String DisplayAllOperations() {
        return super.DisplayAllOperations() + "tb1on - turn burner 1 on;\n"
                + "tb1off - turn burner 1 off;\n" + "tb2on - turn burner 2 on;\n"
                + "tb2off - turn burner 2 off;";
    }
}
