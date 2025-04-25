package Common;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import com.BasePackage.Base_Class;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;



public class TriggerEmail {
	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}
	public static void sendReport() throws IOException {

		final String senderEmail = "Automationmail3@gmail.com";
		final String appPassword = "hawckxwtjekcjtjz";
		final String recipientEmail = configloader().getProperty("emailTo");
		final String recipientccEmail = configloader().getProperty("emailCC1");
//				"asif.alam@speridian.com,sanoop.kuzhikkattil@speridian.com";

		// SMTP Server Properties
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");

		// Create session with Authentication
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);

		try {
			// Create Email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(recipientccEmail));
			message.setSubject("NBFC_CLS Automation Execution Report");

			// Email Body Part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hi Team, \n\nPlease find the automation execution report for the NBFC_CLS project attached.\n\nThis is an auto-generated email from the system. If you have any questions or require further assistance, please contact sanoop.kuzhikkattil@speridian.com directly.\n\n Regards,\nQA Team");
			
			// Attachment Part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String LatestReport =Base_Class.getLatestFileFromFolder( System.getProperty("user.dir") + "\\TestReport\\","html").toString();
			System.out.println("LatestReport:-"+LatestReport);
			String filePath = LatestReport;
			System.out.println("Attachment path is - "+filePath);
			attachmentPart.attachFile(new File(filePath));
			
			// Combine body and attachment parts
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);
			
			// Send Email
			Transport.send(message);
			System.out.println("Email Sent Successfully ***");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
