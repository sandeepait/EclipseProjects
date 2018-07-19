package others;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int rows = scan.nextInt();

		System.out.println("Here is your pattern....!!!");

		//Printing upper half
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				
				System.out.print(j + " ");
			}
			System.out.println("");
		}

		//Printing lower half
		for (int i = rows-1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				
				System.out.print(j + " ");
			}
			System.out.println("");
		}
		
		scan.close();


	}

}
