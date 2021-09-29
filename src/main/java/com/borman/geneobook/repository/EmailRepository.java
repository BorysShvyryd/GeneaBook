//package com.borman.geneobook.repository;
//
//import common.SendEmail;
//
//import java.io.*;
//import java.util.Properties;
//
//public class EmailRepository {
//
//    private final static String  PROPS_FILE = "src/main/resources/email.properties";
//
//    private Message  message        = null;
//    private String   SMTP_AUTH_USER = null;
//    private String   SMTP_AUTH_PWD  = null;
//    private String   EMAIL_FROM     = null;
//    private String   SMTP_SERVER    = null;
//    private String   SMTP_Port      = null;
//    private String   FILE_PATH      = null;
//
//    public boolean SendEmailForConfirmationKey(String UserEmail, String ConfirmationKey) {
//
//        boolean resultSend = false;
//
//        try {
//            InputStream is = new FileInputStream(PROPS_FILE);
//            if (is != null) {
//                Reader reader = new InputStreamReader(is, "UTF-8");
//                Properties props = new Properties();
//                props.load(reader);
//                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_SERVER    = props.getProperty ("server" );
//                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_Port      = props.getProperty ("port"   );
//                com.borman.geneobook.utils.EmailUtil.SendEmail.EMAIL_FROM     = props.getProperty ("from"   );
//                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_AUTH_USER = props.getProperty ("user"   );
//                com.borman.geneobook.utils.EmailUtil.SendEmail.SMTP_AUTH_PWD  = props.getProperty ("pass"   );
//                com.borman.geneobook.utils.EmailUtil.SendEmail.FILE_PATH      = PROPS_FILE;
//
//                String emailTo = this.UserEmail;
//
//                String thema   = props.getProperty ("thema" );
//                String text    = props.getProperty ("text"  );
//                text += " " + ConfirmationKey;
//
//                is.close();
//
//                SendEmail se = new SendEmail(emailTo, thema);
//                if (se.sendMessage(text)) {
//                    System.out.println("Сообщение отправлено");
//                    resultSend =  true;
//                } else {
//                    System.out.println("Сообщение не отправлено");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultSend;
//    }
//
//    //
////    public SendEmail(final String emailTo, final String thema)
////    {
////        Properties properties = new Properties();
////        properties.put("mail.smtp.host"               , SMTP_SERVER  );
////        properties.put("mail.smtp.port"               , SMTP_Port    );
////        properties.put("mail.smtp.auth"               , "true"       );
////        properties.put("mail.smtp.ssl.enable"         , "true"       );
////        properties.put("mail.smtp.socketFactory.port" , SMTP_Port	 );
////        properties.put("mail.smtp.ssl.protocols"	  , "TLSv1.2"	 );
////
////        try {
////            Authenticator auth = new EmailAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD);
////            Session session = Session.getDefaultInstance(properties, auth);
////            session.setDebug(false);
////
////            InternetAddress email_from = new InternetAddress(EMAIL_FROM);
////            InternetAddress email_to   = new InternetAddress(emailTo   );
////            message = new MimeMessage(session);
////
////            message.setFrom(email_from);
////            message.setRecipient(Message.RecipientType.TO, email_to);
////            message.setSubject(thema);
//////		} catch (AddressException e) {
//////			System.err.println(e.getMessage());
////        } catch (MessagingException e) {
////            System.err.println(e.getMessage());
////        }
////    }
////
////    public boolean sendMessage (final String text)
////    {
////        try {
////
////            Multipart mmp = new MimeMultipart();// Содержимое сообщения
////
////            MimeBodyPart bodyPart = new MimeBodyPart();// Текст сообщения
////            bodyPart.setContent(text, "text/plain; charset=utf-8");
////            mmp.addBodyPart(bodyPart);
////
////            message.setContent(mmp);// Определение контента сообщения
////
////            Transport.send(message);// Отправка сообщения
////            return true;
////        } catch (MessagingException e){
////            System.err.println(e.getMessage());
////            e.printStackTrace();
////            return false;
////        }
////    }
//}
