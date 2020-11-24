package smarthome;
import Appliances.BasicThing;
import Appliances.Coffee_maker;
import Appliances.Lamp;
import Appliances.Microwave;
import Appliances.Stove;
import Appliances.Terrarium;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author v.rublova
 */
public class UI {

    public static BasicThing basic;
    ArrayList < Object > house;
    Scanner input;
    public UI() {
        input = new Scanner(System.in);
        house = new ArrayList < Object > ();
        basic = null;
    }
    public void Hello() {
        basic = new BasicThing();
        System.out.println("Hello and welcome to the VS2.34.56 interacting system! " +
            "To list available command type 'h' or 'help'.");
    }

    public void Help() {
        System.out.println("Available commands are listed bellow:");
        System.out.println("help (h) - list operations;");
        System.out.println("help s (h s) - list operations for selected item;");
        System.out.println("add - add things to the house;");
        System.out.println("list - display all appliances in the house;");
        System.out.println("select - select a thingy from list;");
        System.out.println("deselect - deselect a thingy;");
        System.out.println("all on - turn everything on;");
        System.out.println("all on - turn everything off;");
        System.out.println("exit - exit program;");
       
    }
    public void Help_selection() {
        if (basic != null) {
            System.out.println(basic.DisplayAllOperations());
        } else {
            System.out.println("Nothing is selected;");
        }
    }
    public void Split(String com) {

        switch (com) {
            case "help":
            case "h":
                {
                    Help();
                    break;
                }
            case "help s":
            case "h s":
                {
                    Help_selection();
                    break;
                }
            case "all on":
                {
                    TurnAllOn();
                    break;
                }
            case "add":
                {
                    Add();
                    break;
                }
            case "list":
            case "l":
                {
                    DisplayAll();
                    break;
                }
            case "select":
                {
                    Select();
                    break;
                }
            case "deselect":
                {
                    ClearSelection();
                    break;
                }
            case "exit":
                {
                    System.exit(0);
                    break;
                }

                //selection region ends here
            default:
                {
                    if (basic != null) {
                        switch (com) {
                            // basic slection region
                            case "sm":
                                {
                                    System.out.println("Input model:");
                                    basic.SetModel(input.nextLine());
                                    break;
                                }
                            case "ton":
                                {
                                    basic.TurnOn();
                                    System.out.println(basic.DisplayModel()+"power is ON.");
                                    break;
                                }
                            case "toff":
                                {
                                    basic.TurnOff();
                                    System.out.println(basic.DisplayModel()+"power is OFF.");
                                    break;
                                }
                            case "ston":
                                {
                                    System.out.println("Input time (in ms):");
                                    if (basic.SetTimerOn(input.nextInt())) {
                                        System.out.println(basic.DisplayModel()+"power is ON. Timer deleted.");
                                    } else {
                                        System.out.println("Something wrong;");
                                    }
                                    input.nextLine();
                                    break;
                                }
                            case "stoff":
                                {
                                    System.out.println("Input time (in ms):");
                                    if (basic.SetTimerOff(input.nextInt())) {

                                        System.out.println(basic.DisplayModel()+"power is OFF. Timer deleted.");
                                    } else {
                                        System.out.println("Something wrong;");
                                    }
                                    input.nextLine();
                                    break;
                                }
                            case "con":
                                {
                                    basic.Connect();
                                    System.out.println(basic.DisplayModel()+"connection is Up.");
                                    break;
                                }
                            case "discon":
                                {
                                    basic.Disconnect();
                                    System.out.println(basic.DisplayModel()+"connection is Down.");
                                    break;
                                }
                            default:
                                {
                                    if (basic instanceof Coffee_maker) {
                                        Coffee_maker obj = (Coffee_maker) basic;

                                        switch (com) {
                                            case "smode":
                                                System.out.println("Input coffee mode from listed:");
                                                System.out.println(obj.ListModes());
                                                String m = input.nextLine();
                                                if (!obj.SetupMode(m)) {
                                                    System.out.println("No such mode.");
                                                } else {
                                                    System.out.println("Mode changed.");
                                                }   break;
                                            case "dispm":
                                                System.out.println(obj.ListModes());
                                                break;
                                            default:
                                                System.out.println("Command not recognised.");
                                                break;
                                        }
                                    } else if (basic instanceof Microwave) {
                                        Microwave obj = (Microwave) basic;
                                        switch (com) {
                                            case "smode":
                                                System.out.println("Input microwave mode from listed:");
                                                System.out.println(obj.ListModes());
                                                String m = input.nextLine();
                                                if (!obj.SetupMode(m)) {
                                                    System.out.println("No such mode.");
                                                } else {
                                                    System.out.println("Mode changed.");
                                                }   break;
                                            case "dispm":
                                                System.out.println(obj.ListModes());
                                                break;
                                            default:
                                                System.out.println("Command not recognised.");
                                                break;
                                        }
                                    } else if (basic instanceof Lamp) {
                                        Lamp obj = (Lamp) basic;
                                        switch (com) {
                                            case "scolor":
                                                System.out.println("Input color from listed:");
                                                System.out.println(obj.ListColors());
                                                String m = input.nextLine();
                                                if (!obj.SetColor(m)) {
                                                    System.out.println("No such color.");
                                                } else {
                                                    System.out.println("Color changed.");
                                                }   break;
                                            case "dispc":
                                                System.out.println(obj.ListColors());
                                                break;
                                            default:
                                                System.out.println("Command not recognised.");
                                                break;
                                        }
                                    } else if (basic instanceof Stove) {
                                        Stove obj = (Stove) basic;
                                        switch (com) {
                                            case "tb1on":
                                                {
                                                    obj.TurnOnBurner_1();
                                                    System.out.println("Burner1 on "+basic.DisplayModel()+" is ON.");
                                                    break;
                                                }
                                            case "tb2on":
                                                {
                                                    obj.TurnOnBurner_2();
                                                     System.out.println("Burner2 on "+basic.DisplayModel()+" is ON.");
                                                    break;
                                                }
                                            case "tb1off":
                                                {
                                                    
                                                    obj.TurnOffBurner_1();
                                                    System.out.println("Burner1 on "+basic.DisplayModel()+" is OFF.");
                                                    break;
                                                }
                                            case "tb2off":
                                                {
                                                    obj.TurnOffBurner_2();
                                                    System.out.println("Burner2 on "+basic.DisplayModel()+" is OFF.");
                                                    break;
                                                }
                                            default:
                                                System.out.println("Command not recognised.");
                                        }
                                    } else if (basic instanceof Terrarium) {
                                        Terrarium obj = (Terrarium) basic;
                                        switch (com) {
                                            case "upheat":
                                                {
                                                    System.out.println("Input number of degrees: ");
                                                    if (obj.IncreaseHeat(input.nextByte())) {
                                                        System.out.println("Heat increased.");
                                                    } else {
                                                        System.out.println("Can't increase heat. Limit reached.");
                                                    }
                                                    input.nextLine();
                                                    break;
                                                }
                                            case "downheat":
                                                {
                                                    System.out.println("Input number of degrees: ");
                                                    if (obj.LowerHeat(input.nextByte())) {
                                                        System.out.println("Heat decreased.");
                                                    } else {
                                                        System.out.println("Can't dencrease heat. Limit reached.");
                                                    }
                                                    input.nextLine();
                                                    break;
                                                }
                                            case "ton light":
                                                {
                                                    obj.TurnOnLight();
                                                    System.out.println("Lights are ON in "+basic.DisplayModel());
                                                    break;
                                                }
                                            case "toff light":
                                                {
                                                    obj.TurnOffLight();
                                                    System.out.println("Lights are OFF in "+basic.DisplayModel());
                                                    break;
                                                }
                                            case "stoff l":
                                                {
                                                    System.out.println("Input time (in ms):");
                                                    if (obj.TurnLightOffonTimer(input.nextInt())) {

                                                        System.out.println(obj.DisplayModel() + " lights are OFF. Timer deleted.");
                                                    } else {
                                                        System.out.println("Something wrong.");
                                                    }
                                                    input.nextLine();
                                                    break;
                                                }
                                            case "ston l":
                                                {
                                                    System.out.println("Input time (in ms):");
                                                    if (obj.TurnLightOnonTimer(input.nextInt())) {

                                                        System.out.println(obj.DisplayModel() + " lights are ON. Timer deleted.");
                                                    } else {
                                                        System.out.println("Something wrong.");
                                                    }
                                                    input.nextLine();
                                                    break;
                                                }
                                            case "sname":
                                                {
                                                    System.out.println("Input name for animal: ");
                                                    obj.TennantName(input.nextLine());
                                                    System.out.println("Name is set.");
                                                    break;
                                                }
                                            case "sspec":
                                                {
                                                    System.out.println("Input species for animal: ");
                                                    obj.TennantSpecies(input.nextLine());
                                                    System.out.println("Species is set.");
                                                    break;
                                                }
                                            case "feed":
                                                {
                                                    if (obj.Feed()) {
                                                        System.out.println("Animal got fed.");
                                                    } else {
                                                        System.out.println("Can't feed the animal. No food left.");
                                                    }
                                                    break;
                                                }
                                            default:
                                                System.out.println("Command not recognised.");
                                        }
                                    }
                                    break;
                                }
                        }
                    } else {
                        System.out.println("Command not recognised.");
                        break;
                    }
                }
        }
    }

    public void TurnAllOn() {
        for (Object b: house) {
            BasicThing cus = (BasicThing) b;
            cus.TurnOn();
        }
    }
    public boolean DisplayAll() {
        if (!house.isEmpty()) {
            int i = 0;
            for (Object b: house) {

                BasicThing cus = (BasicThing) b;
                i++;
                System.out.println("~!~!~!~!~!~!~!~!~!~!~!~");
                System.out.println("Index: " + i);

                System.out.println(cus.DisplayAll());
            }
            return true;
        } else System.out.println("Your house is empty.");
        return false;
    }
    public void Add() {
        System.out.println("To add a thingy to household enter it's coresponding number.\nTo exit operation press '0'.:");
        System.out.println("1 - Lamp\n2 - coffee maker\n3 - stove\n4 - microwave\n5 - terrarium");
        int imp = 0;
        do {
            imp = input.nextInt();
            input.nextLine();
            switch (imp) {
                case 0:
                    break;
                case 1:
                    {
                        house.add(new Lamp());
                        break;
                    }
                case 2:
                    {
                        house.add(new Coffee_maker());
                        break;
                    }
                case 3:
                    {
                        house.add(new Stove());
                        break;
                    }
                case 4:
                    {
                        house.add(new Microwave());
                        break;
                    }
                case 5:
                    {
                        house.add(new Terrarium());
                        break;
                    }
                default:
                    {
                        System.out.println("Command not recognised.");
                    }
            }
        } while (imp != 0);
        System.out.println("Adding finished.");
    }
    public void ClearSelection() {
        basic = null;
    }

    public void Select() {
        System.out.println("To select a thingy enter it's coresponding number.\nTo exit operation press '0'.:");
        if (this.DisplayAll()) {
            int imp = input.nextInt();
            input.nextLine();
            switch (imp) {
                case 0:
                    break;
                default:
                    {
                        basic = this.getElementByIndex(imp - 1);
                    }
            }
            System.out.println(basic.DisplayModel()+ " is selected.");
        }
    }
    private BasicThing getElementByIndex(int index) {
        try {
            return (BasicThing) house.get(index);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Invalid option");
        } catch (Exception | Error exception) {
            System.out.println("Invalid option");
        }
        return null;
    }
}