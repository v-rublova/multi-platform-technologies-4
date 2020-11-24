package Appliances;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.rublova
 */
public class BasicThing implements AThing {

    protected ExecutorService executor;

    boolean power;
    String model;
    boolean connection;
    byte deterioration_rate;

    public BasicThing() {
        this.power = false;
        this.model = "none";
        this.connection = true;
        this.deterioration_rate = 100;
    }

    public void SetModel(String m) {
        this.model = m;
    }

    public void TurnOn() {
        this.power = true;
    }

    public void TurnOff() {
        this.power = false;
    }

    public boolean SetTimerOn(int timer) {
        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicThing.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.power = true;
            return true;
        });
        return false;
    }

    public boolean SetTimerOff(int timer) {
        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicThing.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.power = false;
            return true;
        });
        return false;
    }

    public void Connect() {
        this.connection = true;
    }

    public void Disconnect() {
        this.connection = false;
    }

    public boolean DisplayPower() {
        return this.power;
    }

    public byte DisplayDeterioration() {
        return this.deterioration_rate;
    }

    public String DisplayModel() {
        return this.model;
    }

    public boolean DisplayConnection() {
        return this.connection;
    }
    public String DisplayAll(){
        String res = "";
        res+=this.model+"\n";
        if (this.power == true) res+="Power: On;\n";
        else res+="Power: Off;\n";
        if (this.connection == true) res+="Connection: Up;\n";
        else res+="Connection: Down;\n";
        res+="Deterioration rate: "+Integer.toString(this.deterioration_rate);
        return res;
    }
    public String DisplayAllOperations(){
        String res = "";
        res+="sm - set model;\n";
        res+="ton - turn on;\n";
        res+="toff - turn off;\n";
        res+="ston - set timer to turn power on;\n";
        res+="stoff - set timer to turn power off;\n";
        res+="con - connect to network;\n";
        res+="discon - disconnect from network;\n";
        return res;
    }

}
