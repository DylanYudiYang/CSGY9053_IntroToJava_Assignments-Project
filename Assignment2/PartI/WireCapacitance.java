//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p1
public class WireCapacitance {

	public static double calculateWireCapacitance(double l, double a, double d0, double d1) {
		double absolutePermittivity = 8.85E-12;
		double diff = 0;
		double pi = Math.PI;
		
		double cf = (pi*absolutePermittivity*l)/Math.log((d1/(2*a)) + Math.sqrt(((d1*d1)/(4*a*a)) - 1));
		double ci = (pi*absolutePermittivity*l)/Math.log((d0/(2*a)) + Math.sqrt(((d0*d0)/(4*a*a)) - 1));
		diff = cf - ci;
	
		return diff;
	}
	
	public static void main(String[] args) {
		double wireLength = 0.5;
		double wireRadius = .002053;
		double initialDistance = .01;
		double finalDistance = .005;
		double capacitanceDifference = 0;
		
		//test, same input as assignment1
		capacitanceDifference = calculateWireCapacitance(wireLength, wireRadius, initialDistance, finalDistance);
		
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  + initialDistance +
		" m to " + finalDistance + "m is " + capacitanceDifference + " farads");
	}
}
