package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;


import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Scope(value = "request")
@Component(value = "dateBean")
@ELBeanName(value = "dateBean")
public class DateBean {

   private GregorianCalendar fecha = new GregorianCalendar();
   private Date today;
   private Date tomorrow;

   public DateBean() {
      today = new Date();
      tomorrow = new Date();
   }

   @PostConstruct
   public void Init() throws IOException {
      today = new Date(fecha.get(Calendar.YEAR) - 1900, fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
      tomorrow = new Date(fecha.get(Calendar.YEAR) - 1900, fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE) + 1);
   }

   public GregorianCalendar getFecha() {
      return fecha;
   }

   public void setFecha(GregorianCalendar fecha) {
      this.fecha = fecha;
   }

   public Date getToday() {
      return today;
   }

   public void setToday(Date today) {
      this.today = today;
   }

   public Date getTomorrow() {
      return tomorrow;
   }

   public void setTomorrow(Date tomorrow) {
      this.tomorrow = tomorrow;
   }
}
