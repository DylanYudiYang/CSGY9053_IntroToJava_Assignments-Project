package vehicles;

public class CargoCycle extends Bicycle {

    public CargoCycle() {
    	
    }
    
    public CargoCycle(int numWheels, String color, double cargoSpace, boolean isElectric) throws VehicleException {
        super(numWheels,color, cargoSpace, isElectric);
        if (numWheels != 2 && numWheels != 3 && numWheels != 4) {
            throw new VehicleException("CargoCycles can only have 2, 3, or 4 wheels");
        }      
    }

    public String toString() {
        return super.toString();
    }
    
    //do not need equals method, just the same as Bicycle Class
}
