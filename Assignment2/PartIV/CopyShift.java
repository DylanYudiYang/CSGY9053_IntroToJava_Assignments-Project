//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p4
public class CopyShift {

	public static void copyShift(int[] sourceArray, int[] destArray, int shift) {
	    int len = sourceArray.length;
	    shift = shift % len; // if shift is larger than length
	    for (int i = 0; i < len; i++) {
	        destArray[(i + shift) % len] = sourceArray[i];
	    }
	}
	
	public static void main(String[] args) {
		
		int[] sourceArray = new int[50];
		int[] destArray = new int[50];
		
		/* initialize the source Array */
		for (int i = 0;i < sourceArray.length; i++) {
			sourceArray[i] = (int)(Math.random()*100);
		}
		
		
		int shiftValue = 3;
		copyShift(sourceArray, destArray, shiftValue);
		
		//Output two arrays
		for (int i = 0;i < sourceArray.length; i++) {
			System.out.print(sourceArray[i] + " ");
		}
		System.out.println();
		for (int i = 0;i < destArray.length; i++) {
			System.out.print(destArray[i] + " ");
		}
	}
}
