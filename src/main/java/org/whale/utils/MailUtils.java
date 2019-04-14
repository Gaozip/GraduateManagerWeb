package org.whale.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.whale.pojo.MailInfo;

public class MailUtils {
	
	private final static String host_163 = "smtp.163.com"; //163的服务器
	private final static String formName_163 = "13115912059@163.com";//邮箱
	private final static String password_163 = "as153759"; //授权码
	private final static String replayAddress_163 = "13115912059@163.com"; //接收者邮箱
	private final static String host_qq = "smtp.qq.com"; //qq的服务器
	private final static String formName_qq = "2982824388@qq.com";//邮箱
	private final static String password_qq = "tvuzoycsqrjidfbi"; //授权码
	private final static String replayAddress_qq = "2982824388@qq.com"; //接收者邮箱

	public static void sendHtmlMail(MailInfo info)throws Exception{
		if(info.getToAddress().endsWith("163.com")){
			info.setHost(host_163);
	        info.setFormName(formName_163);
	        info.setFormPassword(password_163);   
	        info.setReplayAddress(replayAddress_163);
		}else if(info.getToAddress().endsWith("qq.com")){
			info.setHost(host_qq);
	        info.setFormName(formName_qq);
	        info.setFormPassword(password_qq);   
	        info.setReplayAddress(replayAddress_qq);
		}
		
		 Message message = getMessage(info);
        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        // 设置HTML内容
        html.setContent(info.getContent(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        message.setContent(mainPart);
        Transport.send(message);
    }

    public static void sendTextMail(MailInfo info) throws Exception {

    	if(info.getToAddress().endsWith("163.com")){
			info.setHost(host_163);
	        info.setFormName(formName_163);
	        info.setFormPassword(password_163);   
	        info.setReplayAddress(replayAddress_163);
		}else if(info.getToAddress().endsWith("qq.com")){
			info.setHost(host_qq);
	        info.setFormName(formName_qq);
	        info.setFormPassword(password_qq);   
	        info.setReplayAddress(replayAddress_qq);
		}
        Message message = getMessage(info);
        //消息发送的内容
        message.setText(info.getContent());
        Transport.send(message);
    }
	
	private static Message getMessage(MailInfo info) throws Exception{
        final Properties p = System.getProperties() ;
        p.setProperty("mail.smtp.host", info.getHost());
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.user", info.getFormName());
        p.setProperty("mail.smtp.pass", info.getFormPassword());

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session session = Session.getInstance(p, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(p.getProperty("mail.smtp.user"),p.getProperty("mail.smtp.pass"));
            }
        });
        session.setDebug(true);
        Message message = new MimeMessage(session);
        //消息发送的主题
        message.setSubject(info.getSubject());
        //接受消息的人
        message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
        //消息的发送者
        message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"),"毕业生就业管理系统官方团队"));
        // 创建邮件的接收者地址，并设置到邮件消息中
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(info.getToAddress()));
        // 消息发送的时间
        message.setSentDate(new Date());

        return message ;
    }
}
