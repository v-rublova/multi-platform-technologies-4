package Appliances;

/**
 *
 * @author v.rublova
 */
public class Lamp extends BasicThing {

    String color;

    enum colors {
        gray,
        magenta,
        yellow,
        green,
        red,
        white
    }

    public Lamp() {
        super();
        this.color = colors.white.name();
        this.model = "Lamp";
    }

    public String GetColor() {
        return this.color;
    }

    public String ListColors() {
        String s="";
        for (colors c : colors.values()) {
            s+=c.name()+" ";
        }
        return s;
    }

    public boolean SetColor(String color) {
        for (colors c : colors.values()) {
            if (c.name().equals(color)) {
                this.color = color;
                return true;
            }
        }
        return false;
    }
    @Override
    public String DisplayAll(){
        return super.DisplayAll()+"\nLight color: "+this.color;
    }

    @Override
    public String DisplayAllOperations() {
        return super.DisplayAllOperations() + "dispc - display aviable colors;\nscolor - set preferable light color;"; 
    }
}
