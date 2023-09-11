//Yudi Yang, Section I, Dean Christakos, 2023.2.8, A1p2
import java.util.Scanner;

public class GetNameConsole {

	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		System.out.println("Hello, " + name + "!");
	}
}
