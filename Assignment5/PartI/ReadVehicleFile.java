import java.io.*;
import java.util.ArrayList;

import vehicles.*;

/* your tasks:
 * create a class called VehicleException
 * createVehicle should throw a VehicleException
 * in main(), you should catch the VehicleException
 * 
 */
public class ReadVehicleFile {

	public static Vehicle createVehicle(String vehicleName) throws VehicleException {
		
		/* if vehicleName is "Motorcycle" return Motorcycle();
		 * if vehicleName is "Car" return Car();
		 * if vehicleName is "Bicycle" return Bicycle();
		 * if vehicleName is "CargoCycle" return CargoCycle();
		 * if it is not any one of these, it should throw
		 * a VehicleException
		 */
		switch (vehicleName) {
		case "Motorcycle":
			return new Motorcycle();
		case "Car":
			return new Car();
		case "Bicycle":
			return new Bicycle();
		case "CargoCycle":
			return new CargoCycle();
		default:
			throw new VehicleException("Invalid vehicle type: " + vehicleName);
	}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		File f = new File("vehicles.txt");
		
		String inString = null;
		
		try (BufferedReader in = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = in.readLine()) != null) {
				try {
					Vehicle vehicle = createVehicle(line.trim());
					vehicleList.add(vehicle);
				} catch (VehicleException e) {
					System.err.println("Cannot create vehicle: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
		
		for (int i = 0; i < vehicleList.size(); i++) {
			System.out.print("The "+ (i+1) + " element is: ");
            System.out.println(vehicleList.get(i));
            }
		//System.out.println(vehicleList);
		
	}
}
