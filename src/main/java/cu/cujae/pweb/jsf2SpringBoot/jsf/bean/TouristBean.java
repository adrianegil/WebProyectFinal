package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;


import cu.cujae.pweb.jsf2SpringBoot.domain.Country;
import cu.cujae.pweb.jsf2SpringBoot.domain.Tourist;
import cu.cujae.pweb.jsf2SpringBoot.repository.CountryRepository;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.JsfUtils;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "request")
@Component(value = "touristBean")
@ELBeanName(value = "touristBean")
public class TouristBean {

   @Autowired
   private RestService restService;

   @Autowired
   private CountryRepository countryRepository;

   private List<Tourist> touristList;
   private Tourist tourist;
   private Tourist selectedTourist;

   private Country country;

   public TouristBean() {
      touristList = new ArrayList<>();
      tourist = new Tourist();
      selectedTourist = new Tourist();
      country = new Country();
   }

   public void save() {

      try {
         country = countryRepository.findByCod(country.getCountyCod());
         tourist.setTouristCountry(country);
         restService.POST("/api/v1/tourist", tourist, String.class, null);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_InsertLarge")));
      } catch (Exception e) {

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public void delete() {

      try {
         restService.DELETE("/api/v1/tourist/" + selectedTourist.getTouristCod(), null, String.class);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_DeleteLarge")));
      } catch (Exception e) {

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public void update() {

      try {

         country = countryRepository.findByCod(country.getCountyCod());
         selectedTourist.setTouristCountry(country);
         restService.PUT("/api/v1/tourist", null, selectedTourist, String.class, null);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_EditLarge")));

      } catch (Exception e) {

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public Tourist getSelectedTourist() {
      return selectedTourist;
   }

   public void setSelectedTourist(Tourist selectedTourist) {
      this.selectedTourist = selectedTourist;
   }

   public Country getCountry() {
      return country;
   }

   public void setCountry(Country country) {
      this.country = country;
   }

   public List<Tourist> getTouristList() throws IOException {
      ApiRestMapper<Tourist> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/tourist", null, String.class).getBody();
      return apiRestMapper.mapList(response, Tourist.class);
   }

   public void setTouristList(List<Tourist> touristList) {
      this.touristList = touristList;
   }

   public Tourist getTourist() {
      return tourist;
   }

   public void setTourist(Tourist tourist) {
      this.tourist = tourist;
   }
}
