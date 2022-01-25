package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;

import cu.cujae.pweb.jsf2SpringBoot.domain.Car;
import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;
import cu.cujae.pweb.jsf2SpringBoot.domain.Model;
import cu.cujae.pweb.jsf2SpringBoot.domain.Rate;
import cu.cujae.pweb.jsf2SpringBoot.repository.MarkRepository;
import cu.cujae.pweb.jsf2SpringBoot.repository.ModelRepository;
import cu.cujae.pweb.jsf2SpringBoot.repository.RateRepository;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.JsfUtils;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "view")
@Component(value = "carBean")
@ELBeanName(value = "carBean")
@ViewScoped
public class CarBean {

   @Autowired
   private RestService restService;

   @Autowired
   private ModelRepository modelRepository;

   @Autowired
   private MarkRepository markRepository;

   @Autowired
   private RateRepository rateRepository;

   private List<Car> carList;
   private List<Car> availableCarList;
   private Car car;
   private Car selectedCar;
   private List<Model> modelList;
   private Mark mark;
   private Model model;
   private Rate rate;
   private long codModel;

   public CarBean() {
      carList = new ArrayList<>();
      availableCarList = new ArrayList<>();
      car = new Car();
      selectedCar = new Car();
      modelList = new ArrayList<>();
      mark = new Mark();
      model = new Model();
      rate = new Rate();
   }

   public void save() {

      rateRepository.save(rate);

      rate = rateRepository.findByRate(rate.getCost(), rate.getSpecialCost());

      model = modelRepository.findByCod(model.getModelCod());

      car.setModel(model);
      car.setRate(rate);

      try {

         restService.POST("/api/v1/car", car, String.class, null);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_InsertLarge")));

      } catch (Exception e) {
         e.printStackTrace();

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public void delete() {

      if (selectedCar.getSituation().getSituationCod() != 2) {
         try {
            restService.DELETE("/api/v1/car/" + selectedCar.getCarCod(), null, String.class);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_DeleteLarge")));

         } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
         }
      } else {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Not is possible to eliminate a rented car"));
      }
   }

   public void update() {

      rate.setCost(selectedCar.getRate().getCost());
      rate.setSpecialCost(selectedCar.getRate().getSpecialCost());
      rateRepository.save(rate);
      rate = rateRepository.findByRate(rate.getCost(), rate.getSpecialCost());
      selectedCar.setRate(rate);

      try {

         restService.PUT("/api/v1/car", null, selectedCar, String.class, null);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_EditLarge")));

      } catch (Exception e) {

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
   }

   public void loadModelList() {

      ApiRestMapper<Model> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/model-list/" + mark.getMarkCod(), null, String.class).getBody();
      try {
         this.modelList = apiRestMapper.mapList(response, Model.class);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public long getCodModel() {
      return codModel;
   }

   public void setCodModel(long codModel) {
      this.codModel = codModel;
   }

   public List<Model> getModelList() {
      return modelList;
   }

   public void setModelList(List<Model> modelList) {
      this.modelList = modelList;
   }

   public Mark getMark() {
      return mark;
   }

   public void setMark(Mark mark) {
      this.mark = mark;
   }

   public Model getModel() {
      return model;
   }

   public void setModel(Model model) {
      this.model = model;
   }

   public Rate getRate() {
      return rate;
   }

   public void setRate(Rate rate) {
      this.rate = rate;
   }

   public Car getSelectedCar() {
      return selectedCar;
   }

   public void setSelectedCar(Car selectedCar) {
      this.selectedCar = selectedCar;
   }

   public List<Car> getAvailableCarList() throws IOException {

      ApiRestMapper<Car> apiRestMapper = new ApiRestMapper<>();

      String response2 = (String) restService.GET("/api/v1/car-available", null, String.class).getBody();
      return apiRestMapper.mapList(response2, Car.class);
   }

   public void setAvailableCarList(List<Car> availableCarList) {
      this.availableCarList = availableCarList;
   }

   public List<Car> getCarList() throws IOException {
      ApiRestMapper<Car> apiRestMapper = new ApiRestMapper<>();

      String response = (String) restService.GET("/api/v1/car", null, String.class).getBody();
      return apiRestMapper.mapList(response, Car.class);
   }

   public void setCarList(List<Car> carList) {
      this.carList = carList;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }
}
