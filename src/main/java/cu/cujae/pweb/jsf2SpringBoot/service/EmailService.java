package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.config.FreemarkerConfig;
import cu.cujae.pweb.jsf2SpringBoot.domain.Mail;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

   @Autowired
   private JavaMailSender emailSender;
   @Autowired
   private FreemarkerConfig freemarkerConfig;

   public EmailService(JavaMailSender jms) {
      this.emailSender = jms;
   }

   public void send(String from, String to, String subject, String content) {
      SimpleMailMessage mailMsg = new SimpleMailMessage();
      mailMsg.setTo(to);
      mailMsg.setSubject(subject);
      mailMsg.setText(content);
      mailMsg.setFrom(from);
      emailSender.send(mailMsg);
   }

   public void sendSimple(Mail m) throws MessagingException, IOException, TemplateException {
      MimeMessage msg = emailSender.createMimeMessage();
      MimeMessageHelper help = new MimeMessageHelper(msg, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
              StandardCharsets.UTF_8.name());
      Template t = freemarkerConfig.getTemplate("email-simple.ftl");
      String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, m.getModel());

      help.setTo(m.getTo());
      help.setText(html, true);
      help.setSubject(m.getSubject());
      help.setFrom(m.getFrom());

      emailSender.send(msg);
   }
}
