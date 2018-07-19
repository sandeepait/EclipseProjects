package others;

import java.util.Arrays;
import java.util.Scanner;

public class SortAnArray {
	
	//Function to return array out of string

	public static int[] doReturnArray(String inputString) {

		String[] stringArray = inputString.split(" ");
		int[] intArray = new int[stringArray.length];

		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}

		return intArray;
	}

	
	//function to return sorted array
	public static int[] doSortArray(int[] convertedArray) {

		int temp = 0;

		for (int i = 0; i < convertedArray.length; i++) {
			for (int j = 0; j < convertedArray.length-i-1; j++) {
				if (convertedArray[j] >= convertedArray[j + 1]) {
					temp = convertedArray[j + 1];
					convertedArray[j + 1] = convertedArray[j];
					convertedArray[j] = temp;
				}

			}

		}

		return convertedArray;

	}
	
	//main method

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String inputString = "";

		System.out.println("Please enter space separated array elements:-");
		inputString = scan.nextLine();
		scan.close();

		System.out.println("Entered String is: " + inputString);

		int[] convertedArray = doReturnArray(inputString);

		System.out.println("Converted Array is: " + Arrays.toString(convertedArray));

		int[] sortedArray = doSortArray(convertedArray);

		System.out.println("Sorted Array is: " + Arrays.toString(sortedArray));

	}

}
