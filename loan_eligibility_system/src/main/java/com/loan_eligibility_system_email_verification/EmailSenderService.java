package com.loan_eligibility_system_email_verification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendOTPToEmail(String toEmail, String otp) {

		SimpleMailMessage messageOnMail = new SimpleMailMessage();

		messageOnMail.setTo(toEmail);
		messageOnMail.setSubject("Money Maven - Your OTP for Verification");
		messageOnMail.setText("Dear Customer,\r\n" + "\r\n" + "Thank you for choosing Money Maven.\r\n" + "\r\n"
				+ "Your One-Time Password (OTP) for email verification is: " + otp + "\r\n"
				+ "(This OTP is valid for the next 5 minutes)\r\n" + "\r\n"
				+ "Please do not share this OTP with anyone for security reasons.\r\n" + "\r\n" + "Regards,\r\n"
				+ "Team Money Maven");

		mailSender.send(messageOnMail);

	}

	public void sendApprovedMessageToEmail(String toEmail, String loanReferanceId, Double loanAmount) {

		SimpleMailMessage messageOnMail = new SimpleMailMessage();

		messageOnMail.setTo(toEmail);
		messageOnMail.setSubject("Congratulations! Your Loan Application Has Been Approved");
		messageOnMail.setText("Dear User,\r\n" + "\r\n"
				+ "We are pleased to inform you that your loan application (Loan ID:" + loanReferanceId
				+ " ) has been approved after a successful initial review.\r\n" + "\r\n" + "🔍 What’s next?\r\n"
				+ "Your background verification is currently in progress. Once this is completed, the approved loan amount of ₹"
				+ loanAmount + " will be credited to your registered bank account.\r\n" + "\r\n"
				+ "💼 Timeline: Within 2 working days\r\n" + "\r\n" + "📝 Summary:\r\n" + "\r\n"
				+ "Loan Status: Approved ✅\r\n" + "\r\n" + "Background Verification: In Progress 🔄\r\n" + "\r\n"
				+ "Expected Disbursement: Within 2 working days\r\n" + "\r\n" + "Loan Amount: ₹" + loanAmount + "\r\n"
				+ "\r\n" + "If you have any queries, feel free to contact our support team.\r\n" + "\r\n"
				+ "Thank you for choosing Money maven Loans.\r\n" + "\r\n" + "Warm regards,\r\n"
				+ "Loan Processing Team\r\n" + "Money Maven\r\n" + "support@moneymaven.com | ‪+91-9876543210");
		mailSender.send(messageOnMail);

	}
	
	public void sendQueryRaisedMessageToEmail(String toEmail, String tokenId, String userName) {
		
		SimpleMailMessage messageOnMail = new SimpleMailMessage();
		
		messageOnMail.setTo(toEmail);
		messageOnMail.setSubject("Your Loan Queries Support Ticket ["+tokenId+"] Has Been Received – Money Maven");
		messageOnMail.setText("Dear "+userName+",\r\n"
				+ "\r\n"
				+ "Thank you for reaching out to us with your query regarding your loan application. We have successfully received your request and created a support ticket with the ID:\r\n"
				+ "\r\n"
				+ "Ticket ID: ["+tokenId+"]\r\n"
				+ "\r\n"
				+ "Our support team is currently reviewing your concern and will get back to you as soon as possible.\r\n"
				+ "\r\n"
				+ "You can use this Ticket ID to track the status of your query or for any further communication.\r\n"
				+ "\r\n"
				+ "We appreciate your patience and will strive to resolve your issue promptly.\r\n"
				+ "\r\n"
				+ "Best regards,  \r\n"
				+ "[Money Maven]  \r\n"
				+ "Customer Support Team  \r\n"
				+ "[Contact Info]  \r\n"
				+ "[Moneymaven.loans@gmail.com]");
		mailSender.send(messageOnMail);
		
	}

}
