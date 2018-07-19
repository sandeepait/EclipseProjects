package others;

import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int[] intArray = new int[5];
		int largestNumber = 0;

		System.out.println("Please enter 5 random numbers");
		for (int i = 0; i < 5; i++) {
			intArray[i] = scan.nextInt();
		}
		scan.close();

		for (int i = 0; i < intArray.length; i++) {

			if (intArray[i] > largestNumber) {

				largestNumber = intArray[i];
			}

		}
		
		System.out.println("Largest number out of 5 is: "+largestNumber);

	}

}
