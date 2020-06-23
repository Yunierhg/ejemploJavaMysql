// Install the Java helper library from twilio.com/docs/libraries/java
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
/**
 *
 * @author yunie
 */
public class Sender {
    
        // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "--- poner tu id -----";
    public static final String AUTH_TOKEN = "--- poner tu token -----";
    
    public static void sendSms(){
    
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message;
        message = Message
                .creator(new PhoneNumber("--aca el numero que llegara el mensaje--"), // to
                        new PhoneNumber("-- aca el numero que te dan en twilio --"), // from
                        "Desde la clase")
                .create();

        System.out.println(message.getSid());  
    }
    
    
    
    public static void sendWatssap(){         
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        //Your appointment is coming up on {{1}} at {{2}}
        Message message = Message.creator(
                new PhoneNumber("whatsapp:--aca el numero que llegara el mensaje--"),
                new PhoneNumber("whatsapp:-- aca el numero que te dan en twilio --"),
                "probando la APi de whatsapp, Desde clases!!!!")
            .create();

        System.out.println(message.getSid());
    }

    
    

   
    
}
