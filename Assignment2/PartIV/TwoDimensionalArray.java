//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p4
public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		//two nested loops
        for (int i = 0; i < twoDimArray.length; i++) {
            int[] currentArray;
            if (i == 0) {
                currentArray = arrayOne;
            } else {
                currentArray = arrayTwo;
            }
            twoDimArray[i] = new int[currentArray.length];
            for (int j = 0; j < currentArray.length; j++) {
                twoDimArray[i][j] = currentArray[j];
            }
        }
        
        //print
		System.out.println("twoDimArray is ");		
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }

	}
}
