package others;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReader {

	public static List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}

		catch (IOException e) {

			// do something
			e.printStackTrace();
		}
		return lines;
	}

	public static void lineByLineComparison(List l1, List l2) {
		System.out.println("**************Compare List1 and List2 ************");

		int matchFound = 0;

		for (int i = 0; i < l1.size(); i++) {
			for (int j = 0; j < l2.size(); j++) {

				if (l1.get(i) == l2.get(j)) {
					matchFound = 1;

				}

			}

			System.out.println("match Found for row: " + i);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List l1 = readFileInList("F:\\Adhyayan\\SOAP\\File1.txt");
		List l2 = readFileInList("F:\\Adhyayan\\SOAP\\File2.txt");

		int size1 = l1.size();
		int size2 = l2.size();

		System.out.println("Number of rows in list1: " + size1);
		System.out.println("Number of rows in list2: " + size1);

		/*
		 * System.out.println("****************List1***************");
		 * 
		 * for (int i = 0; i < size1; i++) { System.out.println(l1.get(i)); }
		 */

		/*
		 * System.out.println("****************List2***************");
		 * 
		 * for (int i = 0; i < size2; i++) { System.out.println(l2.get(i)); }
		 */

	//	lineByLineComparison(l1, l2);
		
		for(int i=0;i<l1.size();i++) {
			
	
			String s = (String) l1.get(i);
			String[] s3=s.split("\\|");
			
			for(int j=0;j<s3.length;j++) {
				
				System.out.print(s3[j]+" ");
			}
			System.out.println("Row-->"+i);
		}
		
		
	}
}