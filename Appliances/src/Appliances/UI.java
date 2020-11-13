/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appliances;
import java.util.Scanner;
/**
 *
 * @author v.rublova
 */
public class UI {

    public BasicThing basic;
    public void Hello() {
        basic = new BasicThing();
        System.out.println("Hello and welcome to the VS2.34.56 interacting system! "
                + "To list available command type 'h' or 'help'.");
    }

    public void Help() {
        System.out.println("Available commands are listed bellow:");
    }
    public void Timer(){
        System.out.println("Input time (in ms):");
        Scanner input = new Scanner(System.in);
        basic.SetTimerOn(input.nextInt());
    }
    public void Split(String com) {
        switch (com) {
            case "help":
            case "h": {
                Help();
                break;
            }
            case "timer":
            case "t":{
                Timer();
                break;
            }
        }

    }
}
