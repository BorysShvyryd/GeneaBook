package com.borman.geneobook.EmailVerifycator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class EmailTest
{
	private  final  static  String  PROPS_FILE = "src/main/resources/email.properties";

	public static void main(String[] args)
	{
		try {
			InputStream is = new FileInputStream(PROPS_FILE);
            if (is != null) {
				Reader reader = new InputStreamReader(is, "UTF-8");
				Properties props = new Properties();
				props.load(reader);
				com.borman.geneobook.EmailVerifycator.SendEmail.SMTP_SERVER    = props.getProperty ("server" );
				com.borman.geneobook.EmailVerifycator.SendEmail.SMTP_Port      = props.getProperty ("port"   );
				com.borman.geneobook.EmailVerifycator.SendEmail.EMAIL_FROM     = props.getProperty ("from"   );
				com.borman.geneobook.EmailVerifycator.SendEmail.SMTP_AUTH_USER = props.getProperty ("user"   );
				com.borman.geneobook.EmailVerifycator.SendEmail.SMTP_AUTH_PWD  = props.getProperty ("pass"   );
				com.borman.geneobook.EmailVerifycator.SendEmail.FILE_PATH      = PROPS_FILE;
		        	
	        	String emailTo = props.getProperty ("to"   );
	        	String thema   = props.getProperty ("thema");
	        	String text    = props.getProperty ("text" );
		        	
	        	is.close();

				com.borman.geneobook.EmailVerifycator.SendEmail se = new com.borman.geneobook.EmailVerifycator.SendEmail(emailTo, thema);
				se.sendMessage(text);
	        	System.out.println ("Сообщение отправлено");
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
