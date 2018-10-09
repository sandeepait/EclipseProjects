package others;

public class TestStringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "This|is|Regular|string";
		System.out.println("Regular String:- "+s1);
		String s3=s1.replaceAll("|", "/");
		System.out.println("String after replace:"+s3);
		String[] s2 = s3.split("/");
		
		for(int j=0;j<s2.length;j++) {
		System.out.print(s2[j]+" ");
	}
		

	}

}
