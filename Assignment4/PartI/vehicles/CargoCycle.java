package vehicles;

public class CargoCycle extends Bicycle {

    public CargoCycle() {
    	
    }
    
    public CargoCycle(int numWheels, String color, double cargoSpace, boolean isElectric) {
        super(numWheels,color, cargoSpace, isElectric);
    }

    public String toString() {
        return super.toString();
    }
    
    //do not need equals method, just the same as Bicycle Class
}
