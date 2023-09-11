package vehicles;

public class Car extends Vehicle {
    private int numDoors;
    
    public Car() {
    	
    }
    
    public Car (String color, double cargoSpace, int numDoors) throws VehicleException {
        super(4, color, cargoSpace); //4 wheels, has cargo space
        if (numDoors < 2) {
            throw new VehicleException("Cars cannot have fewer than 2 doors");
        }
        this.numDoors = numDoors; //2 or 4
    }

    public int getNumDoors() {
        return numDoors;
    }

    public String PressGasPedal() {
        return "accelerating";
    }

    public String toString() {
        return super.toString() + ", numDoors=" + numDoors;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        
        Car car = (Car) o;
        return numDoors == car.numDoors;
    }
}