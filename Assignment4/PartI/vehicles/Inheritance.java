//Yudi Yang, Section I, Dean Christakos, 2023.2.22, A4p1
package vehicles;

public class Inheritance {

	public static void main(String[] args) {
		//test basic methods
		System.out.println("-----------------------");
		System.out.println("Test basic methods:");
		System.out.println();
		
		Car car1 =new Car("blue", 5, 4);
		System.out.println(car1.getId());
		System.out.println(car1.getNumWheels());
		System.out.println(car1.getColor());
		System.out.println(car1.getCargoSpace());
		System.out.println(car1.getNumDoors());
		System.out.println(car1.PressGasPedal());
	
		//test toString method
		System.out.println();
		System.out.println("-----------------------");
		System.out.println("Test toString method:");
		System.out.println();
		
		String[] accessoriesList = new String[] {"helmet clip", "grip warmers", "usb charger"};
		Vehicle[] vehicleList = new Vehicle[4];
		vehicleList[0] = new Car("blue", 10, 4);
		vehicleList[1] = new Motorcycle("green", accessoriesList);
		vehicleList[2] = new Bicycle(2,"yellow", 0, true);
		vehicleList[3] = new CargoCycle(3, "red", 15, false);
		
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle);
		}
		
		//test equals method
		System.out.println();
		System.out.println("-----------------------");
		System.out.println("Test equals method:");
		System.out.println();
		
		Car car2 =new Car("blue", 5, 4); //same as car1
		Car car3 =new Car("blue", 6, 4);
		
		CargoCycle cargo1 = new CargoCycle(3, "green", 15, false);
		CargoCycle cargo2 = new CargoCycle(3, "green", 15, false);
		CargoCycle cargo3 = new CargoCycle(3, "red", 15, false);
		
		System.out.println(car1.equals(car2));
		System.out.println(car1.equals(car3));
		System.out.println(cargo1.equals(cargo2));
		System.out.println(cargo1.equals(cargo3));
		
	}

}
