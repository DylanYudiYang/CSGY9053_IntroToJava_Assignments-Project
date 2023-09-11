//Yudi Yang, Section I, Dean Christakos, 2023.2.9, A2p3


public class DumbPasswords {
	public static void printDumbPasswords(int m, int n) {
		//print the password in alphabetical order
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= m; j++) {
    			for (int k = 0; k < n; k++) {
    				for (int l = 0; l < n; l++) {
    					for (int p = Math.max(i,j)+1; p <= m; p++) {
    						String password = String.format("%d%d%c%c%d", i, j, 'a'+k, 'a'+l, p);
    						System.out.print(password + " ");
    					}
    				}
    			}
    		}
    	}
	}

	public static void main(String[] args) {
		printDumbPasswords(3, 1);
	}
}





