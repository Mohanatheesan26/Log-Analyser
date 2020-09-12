package com.assignment.email;// Java program to send email

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;


public class MailConfiguration
{
    public void configureMail(String recepient)
    {
        String host="smtp.mailgun.org";
        final String user="postmaster@sandboxc97de748c4294f6385405105597bdf3b.mailgun.org";//change accordingly
        final String password="dcc5fb38ee68a631ab9d2400463f90a8-0f472795-922ac3b3";//change accordingly

        String to=recepient;//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("ERROR");
            message.setText("An Error found in the logfile");

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();}
    }
}
