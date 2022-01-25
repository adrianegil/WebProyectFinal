package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;


import cu.cujae.pweb.jsf2SpringBoot.domain.*;
import cu.cujae.pweb.jsf2SpringBoot.repository.CarRepository;
import cu.cujae.pweb.jsf2SpringBoot.repository.DriverRepository;
import cu.cujae.pweb.jsf2SpringBoot.repository.TouristRepository;
import cu.cujae.pweb.jsf2SpringBoot.security.util.CurrentUserUtils;
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
import java.util.*;

@Scope(value = "request")
@Component(value = "contractBean")
@ELBeanName(value = "contractBean")
public class ContractBean {

   @Autowired
   private RestService restService;

   @Autowired
   private TouristRepository touristRepository;

   @Autowired
   private CarRepository carRepository;

   @Autowired
   private DriverRepository driverRepository;

   private GregorianCalendar fecha;
   private Date today;
   private List<Contract> contractList;
   private Contract contract;
   private Contract selectedContract;
   private Tourist tourist;
   private Car car;
   private Driver driver;
   private boolean asignarChofer = true;

   public ContractBean() {
      today = new Date();
      fecha = new GregorianCalendar();
      contractList = new ArrayList<>();
      contract = new Contract();
      selectedContract = new Contract();
      tourist = new Tourist();
      car = new Car();
      driver = new Driver();
      asignarChofer = true;
   }

   public void save() {

      tourist = touristRepository.findByCod(tourist.getTouristCod());
      car = carRepository.findByCod(car.getCarCod());

      if (driver.getDrivCod() != 0) {
         driver = driverRepository.findByCod(driver.getDrivCod());
      } else {
         driver = null;
      }

      contract.setTourist(tourist);
      contract.setCar(car);
      contract.setDriver(driver);
      contract.setContractorName(CurrentUserUtils.getFullName());

      try {

         restService.POST("/api/v1/contract", contract, String.class, null);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_InsertLarge")));

      } catch (Exception e) {
         e.printStackTrace();

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public void delete() {

      if (selectedContract.getDeliveryDateCar() != null) {
         try {

            restService.DELETE("/api/v1/contract/" + selectedContract.getContractCod(), null, String.class);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_DeleteLarge")));

         } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
         }
      } else {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Not is possible to eliminate an active contract"));
      }
   }

   public void update() {

      if (selectedContract.getDeliveryDateCar() == null) {
         try {

            today = new Date(fecha.get(Calendar.YEAR) - 1900, fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));
            selectedContract.setDeliveryDateCar(today);

            restService.PUT("/api/v1/contract", null, selectedContract, String.class, null);
            Mail mail = new Mail("agil@ceis.cujae.edu.cu", selectedContract.getTourist().getEmail(), "Notification", "Your contract has concluded");
            restService.POST("/api/v1/mail/sendMail", mail, String.class, null);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_EditLarge")));

         } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
         }
      } else {

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", JsfUtils.getStringValueFromBundle("lbl_ErrorConclude")));
      }
   }

   public void cambiar() {

      if (asignarChofer) {

         asignarChofer = false;
      } else {
         asignarChofer = true;
      }
   }

   public boolean getAsignarChofer() {
      return asignarChofer;
   }

   public void setAsignarChofer(boolean asignarChofer) {
      this.asignarChofer = asignarChofer;
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

   public Tourist getTourist() {
      return tourist;
   }

   public void setTourist(Tourist tourist) {
      this.tourist = tourist;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Driver getDriver() {
      return driver;
   }

   public void setDriver(Driver driver) {
      this.driver = driver;
   }

   public Contract getSelectedContract() {
      return selectedContract;
   }

   public void setSelectedContract(Contract selectedContract) {
      this.selectedContract = selectedContract;
   }

   public List<Contract> getContractList() throws IOException {

      ApiRestMapper<Contract> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/contract", null, String.class).getBody();
      return apiRestMapper.mapList(response, Contract.class);
   }

   public void setContractList(List<Contract> contractList) {
      this.contractList = contractList;
   }

   public Contract getContract() {
      return contract;
   }

   public void setContract(Contract contract) {
      this.contract = contract;
   }
}
