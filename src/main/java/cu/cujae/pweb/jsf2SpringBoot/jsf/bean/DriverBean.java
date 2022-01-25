package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;


import cu.cujae.pweb.jsf2SpringBoot.domain.Driver;
import cu.cujae.pweb.jsf2SpringBoot.domain.Mail;
import cu.cujae.pweb.jsf2SpringBoot.security.util.CurrentUserUtils;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.JsfUtils;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "request")
@Component(value = "driverBean")
@ELBeanName(value = "driverBean")
public class DriverBean {

   @Autowired
   private RestService restService;

   private List<Driver> driverList;
   private List<Driver> availableDriverList;
   private Driver driver;
   private Driver selectedDriver;

   public DriverBean() {
      driver = new Driver();
      selectedDriver = new Driver();
      driverList = new ArrayList<>();
      availableDriverList = new ArrayList<>();
   }

   public void save() {

      try {

         restService.POST("/api/v1/driver", driver, String.class, null);

         Mail mail = new Mail("agil@ceis.cujae.edu.cu", driver.getEmail(), "Welcome", "Welcome to RentACar Company");
         restService.POST("/api/v1/mail/sendMail", mail, String.class, null);

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_InsertLarge")));

      } catch (Exception e) {
         e.printStackTrace();

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public void delete() {

      if (selectedDriver.isAvailable()) {
         try {

            restService.DELETE("/api/v1/driver/" + selectedDriver.getDrivCod(), null, String.class);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_DeleteLarge")));

         } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
         }
      } else {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Not is possible to eliminate a driver that is not available"));
      }
   }

   public void update() {

      try {
         restService.PUT("/api/v1/driver", null, selectedDriver, String.class, null);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_EditLarge")));

      } catch (Exception e) {

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public Driver getSelectedDriver() {
      return selectedDriver;
   }

   public void setSelectedDriver(Driver selectedDriver) {
      this.selectedDriver = selectedDriver;
   }

   public List<Driver> getAvailableDriverList() throws IOException {

      ApiRestMapper<Driver> apiRestMapper = new ApiRestMapper<>();

      String response2 = (String) restService.GET("/api/v1/driver-available", null, String.class).getBody();
      return apiRestMapper.mapList(response2, Driver.class);
   }

   public void setAvailableDriverList(List<Driver> availableDriverList) {
      this.availableDriverList = availableDriverList;
   }

   public List<Driver> getDriverList() throws IOException {

      ApiRestMapper<Driver> apiRestMapper = new ApiRestMapper<>();

      String response = (String) restService.GET("/api/v1/driver", null, String.class).getBody();
      return apiRestMapper.mapList(response, Driver.class);
   }

   public void setDriverList(List<Driver> driverList) {
      this.driverList = driverList;
   }

   public Driver getDriver() {
      return driver;
   }

   public void setDriver(Driver driver) {
      this.driver = driver;
   }
}
