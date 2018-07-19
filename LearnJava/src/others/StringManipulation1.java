package others;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StringManipulation1 {

	public static int calc_total_characters(String enteredString) {

		ArrayList<Character> aChar = new ArrayList<Character>();

		for (int i = 0; i < enteredString.length(); i++) {
			aChar.add(enteredString.charAt(i));
		}

		System.out.println("Individual Characters:-" + aChar);

		return aChar.size();
	}

	public static int calc_unique_characters(String enteredString) {

		HashSet<Character> aChar = new HashSet<Character>();

		for (int i = 0; i < enteredString.length(); i++) {
			aChar.add(enteredString.charAt(i));
		}

		Iterator<Character> it = aChar.iterator();

		System.out.println("Individual Characters:-" + aChar);

		while (it.hasNext()) {
			System.out.print( it.next()+ " ");
		}
		System.out.println();
		return aChar.size();
	}
	
	public static int calc_count_characters(String enteredString) {

		HashMap<Character, Integer> aChar = new HashMap<Character, Integer>();
		

		for (int i = 0; i < enteredString.length(); i++) {
			int count =0;
			for(int j=0;j<enteredString.length();j++) {
				if(enteredString.charAt(i)==enteredString.charAt(j)) {
					count++;
				}
			}
			aChar.put(enteredString.charAt(i), count);
			
		}
		System.out.println("Character counts are:-" + aChar);
		
		 for(Map.Entry<Character, Integer> entry:aChar.entrySet()){    
		        char key=entry.getKey();  
		        int b=entry.getValue();  
		        System.out.print("Key is::"+key+" Countis::"+b+"	");  
		           
		    }    
		 System.out.println();
		return aChar.size();
	}


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter any random string:");
		String enteredString = scan.nextLine();

		System.out.println("Entered String is:- " + enteredString);

		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("Total number of characters including spaces:-" + enteredString.length());

		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("Total number of characters excluding spaces:-" + enteredString.replace(" ", "").length());

		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("Total number of characters arrlist:-" + calc_total_characters(enteredString));

		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("Total number of unique characters Hashset:-" + calc_unique_characters(enteredString));
		
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("Total number of unique characters HashMap:-" + calc_count_characters(enteredString));


		scan.close();

	}

}
