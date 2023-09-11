//Yudi Yang, Section I, Dean Christakos, 2023.2.8, A1p3
class WireCapacitance {

	
	public static void main(String[] arguments) {
		double absolutePermittivity = 8.85E-12;
		double initialDistance = .01;
		double finalDistance = .005;
		double wireLength = 0.5;
		double wireRadius = .002053;
		double capacitanceDifference = 0;
		
		double pi = Math.PI;
		double cf = (pi*absolutePermittivity*wireLength)/Math.log((finalDistance/(2*wireRadius)) + Math.sqrt(((finalDistance*finalDistance)/(4*wireRadius*wireRadius)) - 1));
		double ci = (pi*absolutePermittivity*wireLength)/Math.log((initialDistance/(2*wireRadius)) + Math.sqrt(((initialDistance*initialDistance)/(4*wireRadius*wireRadius)) - 1));
		capacitanceDifference = cf - ci;
		
		System.out.println("The wires' change in capacity when moved from a distance of "
		 		+  + initialDistance +
		" m to " + finalDistance + "m is " + capacitanceDifference + " farads");
	}
}