package cu.cujae.pweb.jsf2SpringBoot.controller.v1;

import cu.cujae.pweb.jsf2SpringBoot.domain.Mail;
import cu.cujae.pweb.jsf2SpringBoot.service.EmailService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/mail")
public class EmailController {

   @Autowired
   private EmailService emailService;

   @GetMapping(value = "/send")
   public String send() throws MessagingException, IOException, TemplateException {
      Mail m = new Mail();
      m.setFrom("agil@ceis.cujae.edu.cu");
      m.setTo("user.example@mail.com");
      m.setSubject("Testing email sending");

      Map<String, String> model = new HashMap<String, String>();
      model.put("name", "user.name");
      m.setModel(model);

      emailService.sendSimple(m);
      return "sended";
   }

   @PostMapping(value = "/sendMail")
   public void sendMail(@RequestBody Mail mail) {
      emailService.send(mail.getFrom(), mail.getTo(), mail.getSubject(), mail.getContent());
   }
}
