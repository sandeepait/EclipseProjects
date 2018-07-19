package others;

//https://javaconceptoftheday.com/number-pattern-programs-in-java/

import java.util.Scanner;

public class Pattern1Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows you want in this pattern?");
		int rows = scan.nextInt();

		System.out.println("Here is your pattern....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				if(j%2==0) {
				System.out.print(j + "* ");
				}else {
					System.out.print(j + " ");
				}
			}
			System.out.println("");
		}

		scan.close();


	}

}
