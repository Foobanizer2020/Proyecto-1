package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.AuthenticationBody;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public boolean restorePassword(AuthenticationBody data) {
		String newPass = data.getPassword();
		String subject = "Recuperación de contraseña";
		String body = "" + newPass;
		return sendEmailTool(body, data.getEmail(), subject);
	}
	
	private boolean sendEmailTool(String textMessage, String email,String subject) {
		boolean send = false;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);		
		try {
			helper.setTo(email);
			helper.setText(textMessage, true);
			helper.setSubject(subject);
			sender.send(message);
			send = true;
		} catch (MessagingException e) {
			return false;
		}
		return send;
	}

}
