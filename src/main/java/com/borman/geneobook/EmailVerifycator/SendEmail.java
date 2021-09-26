package com.borman.geneobook.EmailVerifycator;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;

public class SendEmail
{
	private            Message  message        = null;	
	protected  static  String   SMTP_AUTH_USER = null;
	protected  static  String   SMTP_AUTH_PWD  = null;    
	protected  static  String   EMAIL_FROM     = null;
	protected  static  String   SMTP_SERVER    = null;
	protected  static  String   SMTP_Port      = null;
	protected  static  String   FILE_PATH      = null;
//
	public SendEmail(final String emailTo, final String thema)
	{
		Properties properties = new Properties();
		properties.put("mail.smtp.host"               , SMTP_SERVER  );
		properties.put("mail.smtp.port"               , SMTP_Port    );
		properties.put("mail.smtp.auth"               , "true"       );
		properties.put("mail.smtp.ssl.enable"         , "true"       );
		properties.put("mail.smtp.socketFactory.port" , SMTP_Port	 );
		properties.put("mail.smtp.ssl.protocols"	  , "TLSv1.2"	 );

		try {
			Authenticator auth = new EmailAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD);
			Session session = Session.getDefaultInstance(properties, auth);
			session.setDebug(false);
			
			InternetAddress email_from = new InternetAddress(EMAIL_FROM);
			InternetAddress email_to   = new InternetAddress(emailTo   );
			message = new MimeMessage(session); 
			
			message.setFrom(email_from);
			message.setRecipient(Message.RecipientType.TO, email_to);
			message.setSubject(thema);
//		} catch (AddressException e) {
//			System.err.println(e.getMessage());
		} catch (MessagingException e) {
			System.err.println(e.getMessage());
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public boolean sendMessage (final String text)
	{
		boolean result = false;
		try {
			// Содержимое сообщения
	        Multipart mmp = new MimeMultipart();
	        // Текст сообщения	
			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(text, "text/plain; charset=utf-8");
	        mmp.addBodyPart(bodyPart);
			// Определение контента сообщения
	        message.setContent(mmp);
			// Отправка сообщения 
			Transport.send(message);
			result = true;
		} catch (MessagingException e){
			// Ошибка отправки сообщения
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}
