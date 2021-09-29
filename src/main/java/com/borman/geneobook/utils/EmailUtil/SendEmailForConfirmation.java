package com.borman.geneobook.utils.EmailUtil;

import common.SendEmail;

import java.io.*;
import java.util.Properties;

public class SendEmailForConfirmation {

    private final static String  PROPS_FILE = "src/main/resources/email.properties";
    private final String UserEmail;

    public SendEmailForConfirmation(String userEmail) {
        UserEmail = userEmail;
    }

    public boolean SendEmailForConfirmationKey(String ConfirmationKey) {

        boolean resultSend = false;

        try {
            InputStream is = new FileInputStream(PROPS_FILE);
            if (is != null) {
                Reader reader = new InputStreamReader(is, "UTF-8");
                Properties props = new Properties();
                props.load(reader);
                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_SERVER    = props.getProperty ("server" );
                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_Port      = props.getProperty ("port"   );
                com.borman.geneobook.utils.EmailUtil.SendEmail.EMAIL_FROM     = props.getProperty ("from"   );
                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_AUTH_USER = props.getProperty ("user"   );
                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_AUTH_PWD  = props.getProperty ("pass"   );
                com.borman.geneobook.utils.EmailUtil.SendEmail.FILE_PATH      = PROPS_FILE;

                String emailTo = this.UserEmail;

                String thema   = props.getProperty ("thema" );
                String text    = props.getProperty ("text"  );
                text += " " + ConfirmationKey;

                is.close();

                SendEmail se = new SendEmail(emailTo, thema);
                if (se.sendMessage(text)) {
                    System.out.println("Сообщение отправлено");
                    resultSend =  true;
                } else {
                    System.out.println("Сообщение не отправлено");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultSend;
    }
}
