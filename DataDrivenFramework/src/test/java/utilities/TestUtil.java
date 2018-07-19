package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class TestUtil extends BaseClass {
	
	public static String fileName;

	public static void captureScreenshot(String methodName) {
		
		Date d = new Date();
		fileName = methodName+d.toString().replace(" ", "_").replace(":", "_") + ".jpg";

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr,
					new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + fileName));
			FileUtils.copyFile(scr, new File(System.getProperty("user.dir") + "/target/surefire-reports/" + fileName));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
