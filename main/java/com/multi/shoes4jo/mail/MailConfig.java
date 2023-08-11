/* 임 시 보 관
 * package com.multi.shoes4jo.mail;
 * 
 * import java.util.Properties;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.JavaMailSenderImpl;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @Configuration
 * 
 * @RequiredArgsConstructor public class MailConfig {
 * 
 * private final MyInfo myInfo;
 * 
 * @Bean public JavaMailSender javaMailSender() {
 * 
 * Properties mailProperties = new Properties();
 * mailProperties.put("mail.transport.protocol", "smtp");
 * mailProperties.put("mail.smtp.auth", "true");
 * mailProperties.put("mail.smtp.starttls.enable", "true");
 * mailProperties.put("mail.smtp.debug", "true");
 * mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 * mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
 * 
 * JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
 * mailSender.setJavaMailProperties(mailProperties);
 * mailSender.setHost("smtp.gmail.com"); mailSender.setPort(587);
 * mailSender.setUsername(0123aqq); mailSender.setPassword(일단 비워둠 발급받은거 여기 쓰기);
 * mailSender.setDefaultEncoding("utf-8"); return mailSender; } }
 */