package others;

import java.util.Scanner;

public class Pattern2Star {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int rows = scan.nextInt();

		System.out.println("Here is your pattern....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				if(i%2==0) {
				System.out.print(i + "* ");
				}else {
					System.out.print(i + " ");
				}
			}
			System.out.println("");
		}

		scan.close();



	}

}
