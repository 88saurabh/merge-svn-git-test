package com.yash.common;

// File Name SendEmail.java
//saurabh 12:27 26-April2016
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Test {

 public static void main(String[] args)
 {
  /***** CHANGE THESE FOUR VARIABLE VALUES TO REFLECT YOUR ENVIRONMENT ******/
  String user = "weblogic"; // Newly created user on JAMES
  String password = "weblogic"; // user password

  String fromAddress = "weblogic@localhost"; // newlycreateduser@localhost
  String toAddress = "nanda.yash1988@gmail.com"+","+"saurabhlpu07@gmail.com";

  // Create a mail session
  Properties properties = new Properties();
  properties.put("mail.transport.protocol", "smtp");
  properties.put("mail.smtp.host", "localhost");
  properties.put("mail.smtp.port", "25");
  properties.put("mail.smtp.username", user);
  properties.put("mail.smtp.password", password);
 // properties.put("mail.smtp.auth", "true");
  properties.put("mail.smtp.starttls.enable", "true");
  Session session = Session.getDefaultInstance(properties, null);

  try
  {
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(fromAddress));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

   message.setSubject("Email from our JAMES Server");
   message.setText("HI!!!, james server!! why are you irritating me???");
   Transport.send(message);

   System.out.println("Email sent successfully");
  }
  catch (MessagingException e)
  {
   e.printStackTrace();
  }
 }
}
