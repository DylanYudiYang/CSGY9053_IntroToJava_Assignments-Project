//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p3
public class LoopSum {
	
	//method to compute factorial
	public static double factorial(int n) {
	    double fact = 1;
	    for (int i = 2; i <= n; i++) {
	        fact = fact * i;
	    }
	    return fact;
	}

	
	public static double estimateExponential() {
		for(int z=0; z<=15; z++) {
			double e = Math.exp(z);
            System.out.println("e^" + z + " is " + e);
            
            int k = 0;
            double sum = 0.0;
            double term = 1.0; //first term = 1 when k=0
            
            while (Math.abs(e-sum) > 0.001) {
                sum += term;
                k++;
                term = Math.pow(z, k) / factorial(k);
            }

            System.out.println("result for " + k + " iterations: " + sum);
            System.out.println("it requires " + k + " iterations to estimate e^" + z + " within .001");
		}
		
		return -1;
	}
	
	public static void main(String[] args) {	
		estimateExponential();
	}
	
}
