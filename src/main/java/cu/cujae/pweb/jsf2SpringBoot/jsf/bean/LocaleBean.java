package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "localeBean")
@ELBeanName(value = "localeBean")
public class LocaleBean implements Serializable {
   private static final long serialVersionUID = 1L;
   private Locale locale;

   public Locale getLocale() {
      return locale;
   }

   @PostConstruct
   public void Init() throws IOException {
      locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
   }

   public String getLanguage() {
      return locale.getLanguage();
   }

   public void changeLanguage(String lang) {
      locale = new Locale(lang);
      FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
   }
}
