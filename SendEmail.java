import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author yunie
 */
public class SendEmail {
    
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
    
     public static void generateAndSendEmail() throws AddressException, MessagingException {
 
			// Step1
		System.out.println("\n 1st ===> setup Mail Server propiedades..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("la configuracion salio OK..");
 
		// Step2
		System.out.println("\n\n 2nd ===> Obteniendo la sesion del email..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("<---------- A quien se envia el email ---->"));
		generateMailMessage.setSubject("Saludos desde mi app..");
		String emailBody = "Estamos haciendo una prueba. " + "<br><br> Saludos, <br>del Administrador";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Se creo de forma correcta..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Enviando email");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "<---- tu email -->", "<---tu password-->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
    
    
}
