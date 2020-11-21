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
public interface AThing {

    public void SetModel(String m);

    public void TurnOn();

    public void TurnOff();

    public boolean SetTimerOn(int time);

    public boolean SetTimerOff(int time);

    public void Disconnect();

    public void Connect();

    public boolean DisplayPower();

    public String DisplayModel();

    public boolean DisplayConnection();

    public byte DisplayDeterioration();
}

interface KitchenThing {

    public short DisplayHeat();

    public boolean IncreaseHeat(byte t);

    public boolean LowerHeat(byte t);

    public String ShowRecipes();

}

interface GrassyThing {

    public byte DisplayHeat();

    public boolean IncreaseHeat(byte t);

    public boolean LowerHeat(byte t);

    public void TurnOnLight();

    public void TurnOffLight();

    public boolean TurnLightOnonTimer(int timer);

    public boolean TurnLightOffonTimer(int timer);

    public byte DisplayFoodLevel();

    public String DisplayFoodType();

    public boolean Feed();

    public void TennantName(String n);

    public void TennantSpecies(String s);
}
