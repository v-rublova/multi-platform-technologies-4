/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliances;

import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.rublova
 */
public class Terrarium extends BasicThing implements GrassyThing {

    String tennant_name;
    String tennant_species;

    byte temperature;
    byte food_lvl;
    String food_type;
    boolean light;

    public Terrarium() {
        super();
        this.model = "Terrarium";
        this.tennant_name = "none";
        this.tennant_species = "lizard";
        this.temperature = 15;
        this.light = true;
    }

    public byte DisplayHeat() {
        return this.temperature;
    }

    public boolean IncreaseHeat(byte t) {
        if (this.temperature + t > 25) {
            return false;
        } else {
            this.temperature += t;
            return true;
        }
    }

    public boolean LowerHeat(byte t) {
        if (this.temperature - t < 5) {
            return false;
        } else {
            this.temperature -= t;
            return true;
        }
    }

    public void TurnOnLight() {
        this.light = true;
    }

    public void TurnOffLight() {
        this.light = false;
    }

    public void TennantName(String n) {
        this.tennant_name = n;
    }

    public void TennantSpecies(String s) {
        this.tennant_species = s;
    }

    public boolean TurnLightOnonTimer(int timer) {
        this.executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicThing.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.light = true;
            return true;
        });
        return false;
    }


    public boolean TurnLightOffonTimer(int timer) {
        this.executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicThing.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.light = false;
            return true;
        });
        return false;
    }


    public byte DisplayFoodLevel() {
        return this.food_lvl;
    }

    public String DisplayFoodType() {
        return this.food_type;
    }

    public boolean Feed() {
        if (this.food_lvl >= 20){
            this.food_lvl-=20;
            return true;
        }
        return false;
    }
    @Override
    public String DisplayAll(){
        String res = super.DisplayAll();
        res+="\nAnimal species:"+this.tennant_species+"\n";
        res+="Animal name:"+this.tennant_name+"\n";
        if (this.light == true) {
            res += "Light: On;\n";
        } else {
            res += "Light: Off;\n";
        }
        res+="Temperature: "+Integer.toString(this.temperature)+"\n";
        res+="Food level: "+Integer.toString(this.food_lvl)+"\n";
        res+="Food type: "+this.food_type+"\n";
        return res;
    }

    @Override
    public String DisplayAllOperations() {
       String res = super.DisplayAllOperations();
       res+="upheat - increase heat;\n";
       res+="downheat - decrease heat;\n";
       res+="ton light - turn lights on;\n";
       res+="toff light - turn lights off;\n";
       res+="sname - set animal name;\n";
       res+="sspec - set animal species;\n";
       res+="ston l - set timer to turn lights on;\n";
       res+="stoff l - set timer to turn lights off;\n";
       res+="feed - feed the animal;";
       return res;
    }

}
