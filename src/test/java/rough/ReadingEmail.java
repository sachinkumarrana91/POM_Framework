package rough;

import java.util.*;
import javax.mail.*;

public class ReadingEmail {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {

        	Authenticator auth = new javax.mail.Authenticator(){
    			public PasswordAuthentication getPasswordAuthentication(){
    				return new PasswordAuthentication("Sachin.Kumar@rsystems.com", "Welcome7851rs");
    			}
    		};
    		
    		
    		Session session = Session.getDefaultInstance(props, auth);            
    		Store store = session.getStore();
            store.connect("RSI-NOD-EXMDB6.india.rsystems.com", "Sachin.Kumar@rsystems.com", "Welcome7851rs");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                //System.out.println("FROM:" + address.toString());
            }
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            //System.out.println("SENT DATE:" + msg.getSentDate());
            //System.out.println("SUBJECT:" + msg.getSubject());
            //System.out.println("CONTENT:" + bp.getContent());
            String s = (String)bp.getContent();
            System.out.println("Verification Code: " + s.substring(s.indexOf("Verification Code:")).substring(19, 24));
            
            
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
}