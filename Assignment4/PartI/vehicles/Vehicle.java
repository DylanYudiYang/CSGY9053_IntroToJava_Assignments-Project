package vehicles;

import java.util.Objects;

public class Vehicle {
    private static int next_id = 1;
    private int id;
    private int numWheels;
    private String color;
    private double cargoSpace; // in cubic feet or liters
    
    public Vehicle() {
        this.id = next_id++;
    }

    public Vehicle(int numWheels, String color, double cargoSpace) {
        this.id = next_id++;
        this.numWheels = numWheels;
        this.color = color;
        this.cargoSpace = cargoSpace;
    }

    public int getId() {
        return id;
    }
    
    public int getNumWheels() {
    	return numWheels;
    }
    	
    public String getColor() {
        return color;
    }

    public double getCargoSpace() {
        return cargoSpace;
    }

    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", numWheels=" + numWheels + ", color=" + color + ", cargoSpace=" + cargoSpace + "]";
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        
        Vehicle vehicle = (Vehicle) o;
        return numWheels == vehicle.numWheels &&
                Double.compare(vehicle.cargoSpace, cargoSpace) == 0 &&
                Objects.equals(color, vehicle.color);
    }
}







