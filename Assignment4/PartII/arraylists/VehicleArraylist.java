//Yudi Yang, Section I, Dean Christakos, 2023.2.22, A4p2
package arraylists;
import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
        Motorcycle redMotorcycle = new Motorcycle("red", new String[] {"grip warmers, usb charger"});
        Car blueCar1 = new Car("blue", 20, 4);
        Car blueCar2 = new Car("blue", 20, 4);
        Bicycle blackBicycle = new Bicycle(2, "black", 0, false);
        CargoCycle greenCargoCycle1 = new CargoCycle(3, "green", 10, false);
        CargoCycle greenCargoCycle2 = new CargoCycle(3, "green", 10, false);
        Car grayCar = new Car("gray", 10, 2);
        Car whiteCar = new Car("white", 25, 4);

        // Add Vehicle objects to the ArrayList
        vehicleArrayList.add(redMotorcycle);
        vehicleArrayList.add(blueCar1);
        vehicleArrayList.add(blueCar2);
        vehicleArrayList.add(blackBicycle);
        vehicleArrayList.add(greenCargoCycle1);
        vehicleArrayList.add(greenCargoCycle2);
        vehicleArrayList.add(grayCar);
        vehicleArrayList.add(whiteCar);
        
        // Calculate average cargo space
        double totalCargoSpace = 0;
        int numCars = 0;
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                totalCargoSpace += car.getCargoSpace();
                numCars++;
            }
        }
        double avgCargoSpace = totalCargoSpace / numCars;
        System.out.println("Average cargo space of all Car objects is: " + avgCargoSpace);
        System.out.println();
        
        // Find the first blue Car object and remove matching objects from the ArrayList
        Car carMatch = null;
        int index = 0;
        int iteration = vehicleArrayList.size();
        
        for (int i=0;i < iteration; i++) {
        	Vehicle vehicle = vehicleArrayList.get(index);
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                if (car.equals(blueCar1)) {
                    if (carMatch == null) {
                        carMatch = car;
                        System.out.println("Matching Car (same) is:" + car.toString());
                        vehicleArrayList.remove(index);
                    }
                    else {
                        System.out.println("Matching Car (equal) is:" + car.toString());
                        vehicleArrayList.remove(index);
                    }
                    index--;
                }
            }
            index++;
        }
        System.out.println();
        
        // Print out remaining objects in the ArrayList
        System.out.println("Remaining objects:");
        for (Vehicle vehicle : vehicleArrayList) {
            System.out.println(vehicle.toString());
        }
    }
        

	

}
