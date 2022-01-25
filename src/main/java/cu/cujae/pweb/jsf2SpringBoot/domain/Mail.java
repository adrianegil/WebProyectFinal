package cu.cujae.pweb.jsf2SpringBoot.domain;

import java.util.Map;

public class Mail {
   private String from, to, subject, content;
   private Map<String, String> model;

   public Mail() {

   }

   public Mail(String from, String to, String subject, String content, Map<String, String> model) {
      super();
      this.from = from;
      this.to = to;
      this.subject = subject;
      this.content = content;
      this.model = model;
   }

   public Mail(String from, String to, String subject, String content) {
      super();
      this.from = from;
      this.to = to;
      this.subject = subject;
      this.content = content;
   }

   public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getTo() {
      return to;
   }

   public void setTo(String to) {
      this.to = to;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Map<String, String> getModel() {
      return model;
   }

   public void setModel(Map<String, String> model) {
      this.model = model;
   }
}
