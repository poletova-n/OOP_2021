package lab3.classes;


import lab3.Deep;

@Deep()
public class Animals {
    protected String name;
    protected String typeOfPowerSupply = "heterotrophic";
    protected boolean skeleton;
    public Animals(String name){
        this.name = name;
    }
    public Animals(){}

    @Override
    public String toString() {
        return "Animal -> " +name;
    }

    public String getCharacteristic(){
        return toString() +"\n"+
                "Type of power supply -> " + typeOfPowerSupply;
    }
}
