package cn.lj.ssh.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * ���ฺ�����ʼ����ṩ��̬����sendMail
 * 
 * @author Rabit
 * 
 */
public class SendMailUnitl {
	/**
	 * @author Rabit
	 * @param to :�ռ��˵������ַ
	 * @param code :�ṩ64λ������       
	 */

	public static void senMail(String to,String code) {
		// ��ȡ���Ӷ���
		Properties properties = new Properties();
		try {
			MailSSLSocketFactory sfFactory=new MailSSLSocketFactory();
			sfFactory.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sfFactory);
			properties.setProperty("mail.smtp.host", "smtp.qq.com");
			properties.setProperty("mail.smtp.auth", "true");
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		
		Session session = Session.getInstance(properties,new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("794933224@qq.com", "atwmwywowofhbbfi");
			}
		});
		// �����ʼ�����
		Message message = new MimeMessage(session);
		try {
			// ���÷�����
			message.setFrom(new InternetAddress("794933224@qq.com"));
			// �����ռ���
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// ���ñ���
			message.setSubject("����xx�̳ǵĹٷ������ʼ�");
			// �����ʼ�������
			message.setContent("<h1>xx�̳ǹٷ������ʼ�!������������ɼ������!</h1><h3><a href='http://localhost:8080/shop/user_active.action?code="+code+"'>http://localhost:8080/shop/user_active.action?code="+code+"</a></h3>",
					"text/html;charset=UTF-8");
			// �����ʼ�
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
