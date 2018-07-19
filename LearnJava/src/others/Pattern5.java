package others;

import java.util.Scanner;

public class Pattern5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int rows = scan.nextInt();

		System.out.println("Here is your pattern....!!!");
		
		for (int i = 1; i <=rows; i++) {
			for (int j = rows; j >= i; j--) {
				
				System.out.print(j + " ");
			}
			System.out.println("");
		}
		
		scan.close();

	}

}
