package missingNumber;

import java.util.Arrays;
import java.util.Scanner;

public class FindMissingNumber {

	// Converting space separated string input to integer array

	public static int[] intArray(String input) {

		String[] tokens = input.split(" ");

		int[] arrayNumbers = new int[tokens.length];

		for (int i = 0; i < tokens.length; i++) {
			arrayNumbers[i] = Integer.parseInt(tokens[i]);
		}

		return arrayNumbers;
	}

	// finding missing number

	public static int findingMissingNumber(int n, int[] returnedArray) {

		int sumN = n * (n + 1) / 2;
		int sumArray = 0;

		for (int i = 0; i < returnedArray.length; i++) {
			sumArray = sumArray + returnedArray[i];
		}

		return (sumN - sumArray);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 0;
		String input;

		Scanner scanNum = new Scanner(System.in);

		Scanner scanArray = new Scanner(System.in);

		System.out.println("Please enter the value of n in first n numbers: ");
		n = scanNum.nextInt();

		System.out.println("Please enter the array space separated with missing number:");
		input = scanArray.nextLine();

		System.out.println("Entered String is: " + input);

		int[] returnedArray = intArray(input);

		System.out.println("Returned int array is: " + Arrays.toString(returnedArray));
		
		System.out.println("The missing number is: "+findingMissingNumber(n,returnedArray));

		scanNum.close();
		scanArray.close();

	}

}
