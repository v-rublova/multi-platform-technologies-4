/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliances;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.rublova
 */
public class BasicThing implements AThing {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

     boolean power;
     String model;
     boolean connection;
     byte deterioration_rate;

    public void TurnOn() {
        this.power = true;
    }
    public void TurnOff() {
        this.power = false;
    }
    public void SetTimerOn(int timer) {
        executor.submit(() -> {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicThing.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(this.model+" is ON. Timer deleted.");          
        });
    }
    public void SetTimerOff(int timer) {
        executor.submit(() -> {
            try {
                Thread.sleep(timer);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicThing.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(this.model+" is OFF. Timer deleted.");          
        });
    }
    
    
    public void Connect(){
        this.connection = true;
    }
    public void Disconnect(){
        this.connection = false;
    }

    public boolean DisplayPower() {
        return this.power;
    }

    public byte DisplayDeterioration() {
       return this.deterioration_rate;
    }
    public String DisplayModel(){
        return this.model;
    }
    public boolean DisplayConnection(){
        return this.connection;
    }

}
