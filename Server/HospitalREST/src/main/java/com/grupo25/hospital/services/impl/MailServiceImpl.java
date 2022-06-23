package com.grupo25.hospital.services.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo25.hospital.services.MailService;
import com.grupo25.hospital.utils.DynamicTemplatePersonalization;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

@Service
public class MailServiceImpl implements MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	@Override
	public String sendWelcomeEmail(String toEmail, String username) throws IOException {
		// the sender email should be the same as we used to Create a Single Sender Verification
				Email from = new Email("holistichospital0122@outlook.com");
				Email to = new Email(toEmail);
				Mail mail = new Mail();
				
				DynamicTemplatePersonalization personalization = new DynamicTemplatePersonalization();
				personalization.addTo(to);
				mail.setFrom(from);
				mail.setSubject("Bienvenido/a");
				// Variables de la plantilla
				personalization.addDynamicTemplateData("username", username);
				
				mail.addPersonalization(personalization);
				
				// Id de plantilla
				mail.setTemplateId("d-baf6b70f99e74e5689f5e918f6c8bc70");
				
				// SendGrid key
				SendGrid sg = new SendGrid("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");
				Request request = new Request();

				try {
					request.setMethod(Method.POST);
					request.setEndpoint("mail/send");
					request.setBody(mail.build());
					Response response = sg.api(request);
					 logger.info(response.getBody());
					return response.getBody();
				} catch (IOException ex) {
					throw ex;
				}
	}
	
	@Override
	public String sendRequestPasswordEmail(String toEmail, String username, Long id) throws IOException {
				Email from = new Email("holistichospital0122@outlook.com");
				Email to = new Email(toEmail);
				Mail mail = new Mail();
				
				DynamicTemplatePersonalization personalization = new DynamicTemplatePersonalization();
				personalization.addTo(to);
				mail.setFrom(from);
				mail.setSubject("Recuperar contraseña");
				// Variables de la plantilla
				personalization.addDynamicTemplateData("username", username);
				personalization.addDynamicTemplateData("id", id.toString());
				
				mail.addPersonalization(personalization);
				
				// Id de plantilla
				mail.setTemplateId("d-4b364f86776d4c158d75effdd00c2730");
				
				// SendGrid key
				SendGrid sg = new SendGrid("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");
				Request request = new Request();

				try {
					request.setMethod(Method.POST);
					request.setEndpoint("mail/send");
					request.setBody(mail.build());
					Response response = sg.api(request);
					 logger.info(response.getBody());
					return response.getBody();
				} catch (IOException ex) {
					throw ex;
				}
	}
	
}