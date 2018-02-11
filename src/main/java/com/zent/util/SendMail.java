package com.zent.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zent.bean.Cart;

public class SendMail {
	public static boolean sendMail(String email, String name, String address,List<String> contend,String phone,long sum) {
		final String username = "ntd0021995@gmail.com";
		final String password = "daihockt";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ntd0021995@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ntd0021995@gmail.com"));
			message.setSubject("Cart Infomation");
			message.setContent("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
					"    <title>Document</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"    <h1>Dear"+name+", Address: "+address+" , Phone: "+phone+"</h1>\r\n" + 
					"    <p>Total : $ "+sum+"</p>\r\n" + 
					"    <p>Product Information You Buy:</p>\r\n" + 
					"    <p>"+contend+"</p>\r\n" + 
					"    <h2>Thank You !</h2>\r\n" + 
					"</body>\r\n" + 
					"</html>", "text/html; charset=utf-8");
		
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
}
