package others;

import java.util.Scanner;

public class Pattern6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int rows = scan.nextInt();

		System.out.println("Here is your pattern....!!!");
		
		for (int i = rows; i >=1; i--) {
			for (int j = rows; j >= i; j--) {
				
				System.out.print(j + " ");
			}
			System.out.println("");
		}
		
		scan.close();


	}

}
