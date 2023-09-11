package vehicles;

public class Bicycle extends Vehicle {
    private boolean isElectric;

    public Bicycle() {
    	
    }
    
    public Bicycle(int numWheels, String color, double cargoSpace, boolean isElectric) {
        super(numWheels, color, cargoSpace); //2 wheels, no cargo space
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public String Pedal() {
        return "pedaling";
    }

    public String toString() {
        return super.toString() + ", isElectric=" + isElectric;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicycle)) return false;
        if (!super.equals(o)) return false;
        
        Bicycle bicycle = (Bicycle) o;
        return isElectric == bicycle.isElectric;
    }
}
