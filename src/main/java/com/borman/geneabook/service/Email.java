//package com.borman.geneabook.service;
//
//import com.borman.geneabook.entity.pojo.EmailAuthenticator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.util.Properties;
//
//@Service
//public class Email {
//
//    @Value("${email.smtp-server}")
//    private String SMTP_SERVER;
//
//    @Value("${email.smtp-port}")
//    private String SMTP_Port;
//
//    @Value("${email.email-from}")
//    private String EMAIL_FROM;
//
//    @Value("${email.smtp-auth-user}")
//    private String SMTP_AUTH_USER;
//
//    @Value("${email.smtp-auth-pwd}")
//    private String SMTP_AUTH_PWD;
//
//    private Message message = null;
//
//    private static final Logger log = LogManager.getLogger(Email.class);
//
//    public boolean SendEmail(String userEmail,
//                             String emailTopic,
//                             String emailText) {
//
//        boolean resultSend = false;
//
//        SendEmailCreate(userEmail, emailTopic);
//
//        if (sendMessage(emailText)) {
//            log.info("Message sent");
//            resultSend = true;
//        } else {
//            log.error("Message not sent");
//        }
//
//        return resultSend;
//    }
//
//    private void SendEmailCreate(final String emailTo, final String thema) {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host",                SMTP_SERVER);
//        properties.put("mail.smtp.port",                SMTP_Port);
//        properties.put("mail.smtp.auth",                "true");
//        properties.put("mail.smtp.ssl.enable",          "true");
//        properties.put("mail.smtp.socketFactory.port",  SMTP_Port);
//        properties.put("mail.smtp.ssl.protocols",       "TLSv1.2");
//
//        try {
//            Authenticator auth = new EmailAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD);
//            Session session = Session.getDefaultInstance(properties, auth);
//            session.setDebug(false);
//
//            InternetAddress email_from = new InternetAddress(EMAIL_FROM);
//            InternetAddress email_to = new InternetAddress(emailTo);
//            message = new MimeMessage(session);
//
//            message.setFrom(email_from);
//            message.setRecipient(Message.RecipientType.TO, email_to);
//            message.setSubject(thema);
//
//            log.info("Authentication SMTP-server: OK");
//
//        } catch (MessagingException e) {
//            log.error("Authentication SMTP-server: " + e.getMessage());
//        }
//    }
//
//    private boolean sendMessage(final String text) {
//        try {
//
//            Multipart mmp = new MimeMultipart();
//
//            MimeBodyPart bodyPart = new MimeBodyPart();
//            bodyPart.setContent(text, "text/plain; charset=utf-8");
//            mmp.addBodyPart(bodyPart);
//
//            message.setContent(mmp);
//
//            Transport.send(message);
//
//            log.info("Transport message: OK");
//
//            return true;
//        } catch (MessagingException e) {
//            log.error("Transport message: " + e.getMessage());
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
