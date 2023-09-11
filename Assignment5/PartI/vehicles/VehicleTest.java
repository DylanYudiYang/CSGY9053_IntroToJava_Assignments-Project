//Test code
package vehicles;

public class VehicleTest {
    public static void main(String[] args) {
        try {
            // Attempt to create a car with -10 cargo space
            Car car1 = new Car("blue", -10, 4);
        } catch (VehicleException e1) {
            System.out.println("Error creating car: " + e1.getMessage());
        }
        
        try {
            // Attempt to create a car with 1 door
            Car car2 = new Car("yellow", 10, 1);
        } catch (VehicleException e2) {
            System.out.println("Error creating car: " + e2.getMessage());
        }
        
        try {
            // Attempt to create a motorcycle with a null accessories array
            CargoCycle cargo1 = new CargoCycle(6, "green", 15, true);
        } catch (VehicleException e3) {
            System.out.println("Error creating motorcycle: " + e3.getMessage());
        }
    }
}
