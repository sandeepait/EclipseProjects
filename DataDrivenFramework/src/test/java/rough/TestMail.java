package rough;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import utilities.MonitoringMail;
import utilities.TestConfig;

public class TestMail {
	public static void main(String[] args) throws AddressException, MessagingException {

		/*
		 * Add these variables into (TestConfig.attachmentPath,
		 * TestConfig.attachmentName) sendMail method if you want to attach any
		 * screenshots
		 */		
                MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);

	}

}
