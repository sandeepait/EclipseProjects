package others;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter any number: ");
		number=scan.nextInt();
		scan.close();
		
		if(number%2==0) {
			
			System.out.println("Number "+number+" is an even number.");
			
		}else {
			System.out.println("Number "+number+" is an odd number.");
		}
		

	}

}
