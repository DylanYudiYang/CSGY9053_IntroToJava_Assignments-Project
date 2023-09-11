//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p2
public class BoxingWeightClass {

	public static String findWeightClass(float weight) {
		// this is really only valid for weights greater than 0.
		String weightclass;
		
		if (weight <= 0) {
			weightclass = "invalid weight (<=0)";
		}
		else if (weight <= 108) {
			weightclass = "light flyweight";
		}
		else if (weight <= 115) {
			weightclass = "flyweight";
		}
		else if (weight <= 123) {
			weightclass = "bantamweight";
		}
		else if (weight <= 132) {
			weightclass = "lightweight";
		}
		else if (weight <= 141) {
			weightclass = "light welterweight";
		}
		else if (weight <= 152) {
			weightclass = "welterweight";
		}
		else if (weight <= 165) {
			weightclass = "middleweight";
		}
		else if (weight <= 178) {
			weightclass = "Light heavyweight";
		}
		else if (weight <= 201) {
			weightclass = "Heavyweight";
		}
		else {
			weightclass = "Super heavyweight";
		}
		
		return weightclass;
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * income using Scanner because you will have to convert
		 * a command line argument to an float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "weight" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		float weight = 155;
		String weightClass = findWeightClass(weight);
		
		System.out.println("The weight class for the weight " + weight + " is " 
		+ weightClass);
		
	}
}
