package otpGenerationProgram;

public class GenerateOtp {
	
static int otp;
	
	public static int doGenerateOtp() {
		
		otp = (int) (Math.random()*10000);
		return otp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		do {
			
			otp = (int) (Math.random()*10000);
			
		}while (otp<1000);
		
		System.out.println("The value of OTP is: "+otp);
		

	}

}
