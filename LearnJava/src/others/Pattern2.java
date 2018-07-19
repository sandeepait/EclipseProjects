package others;

//https://javaconceptoftheday.com/number-pattern-programs-in-java/

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int rows = scan.nextInt();

		System.out.println("Here is your pattern....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				
				System.out.print(i + " ");
			}
			System.out.println("");
		}

		scan.close();

	}

}
