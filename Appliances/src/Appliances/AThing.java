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

    public void TurnOn();
    public void TurnOff();
    
    public void SetTimerOn(int time);
    public void SetTimerOff(int time);

    public void Disconnect();
    public void Connect();
    
    public boolean DisplayPower();
    public String DisplayModel();
    public boolean DisplayConnection();
    public byte DisplayDeterioration();
}
interface KitchenThing{
    public void DisplayHeat();
    
    public void IncreaseHeat(); 
    public void LowerHeat();
    
    public void ShowRecipes();
    
}
interface GrassyThing{
    public void DisplayHeat();
    
    public void IncreaseHeat(); 
    public void LowerHeat();
    
    public void TurnOnLight();
    public void TurnOffLight();
    
    public void TurnLightOnonTimer();
    public void TurnLightOffonTimer();
    
    public void DisplayFoodLevel();
    public void DisplayFoodType();
    
    public void Feed();
    
    public void TennantName();
    public void TennantSpecies();
}