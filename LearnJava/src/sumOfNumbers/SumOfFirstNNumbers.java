package sumOfNumbers;

import java.util.Scanner;

public class SumOfFirstNNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter for how many numbers sum is wanted: ");
		n=scan.nextInt();
		
		int sum = n*(n+1)/2;
		
		System.out.println("Sum of first "+n+" numbers is:"+sum);
		
		scan.close();

	}

}
