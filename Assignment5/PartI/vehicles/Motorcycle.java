package vehicles;

import java.util.Arrays;

public class Motorcycle extends Vehicle {
    private String[] accessories;

    public Motorcycle() {
    	
    }
    
    public Motorcycle(String color, String[] accessories) throws VehicleException {
        super(2, color, 0); //2 wheels, no cargo space
        this.accessories = accessories;
    }

    public String[] getAccessories() {
        return accessories;
    }

    public String TwistThrottle() {
        return "accelerating";
    }

    public String toString() {
        return super.toString() + ", accessories=" + Arrays.toString(accessories);
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motorcycle)) return false;
        if (!super.equals(o)) return false;
        
        Motorcycle motor = (Motorcycle) o;
        return Arrays.equals(accessories, motor.accessories);
    }
}