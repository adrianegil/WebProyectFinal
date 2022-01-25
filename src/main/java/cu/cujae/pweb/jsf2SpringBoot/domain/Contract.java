package cu.cujae.pweb.jsf2SpringBoot.domain;

import java.util.Date;
import java.util.Optional;

public class Contract {

   private Car car;
   private Tourist tourist;
   private long contractCod;
   private Date beginDate;
   private Date endDate;
   private int cantDaysExt;
   private String paymentWay;
   private Date deliveryDateCar = null;
   private Double totalCost = null;
   private String contractorName = null;
   private Driver driver = null;

   public Contract() {
   }


   public Contract(Car car, Tourist tourist, long contractCod, Date beginDate, Date endDate, int cantDaysExt, String paymentWay, Driver driver, Date deliveryDateCar, Double totalCost, String contractorName) {
      this.car = car;
      this.tourist = tourist;
      this.contractCod = contractCod;
      this.beginDate = beginDate;
      this.endDate = endDate;
      this.cantDaysExt = cantDaysExt;
      this.paymentWay = paymentWay;
      this.driver = driver;
      this.deliveryDateCar = deliveryDateCar;
      this.totalCost = totalCost;
      this.contractorName = contractorName;
   }

   public Driver getDriver() {
      return driver;
   }

   public void setDriver(Driver driver) {
      this.driver = driver;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Tourist getTourist() {
      return tourist;
   }

   public void setTourist(Tourist tourist) {
      this.tourist = tourist;
   }

   public long getContractCod() {
      return contractCod;
   }

   public void setContractCod(long contractCod) {
      this.contractCod = contractCod;
   }

   public Date getBeginDate() {
      return beginDate;
   }

   public void setBeginDate(Date beginDate) {
      this.beginDate = beginDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   public int getCantDaysExt() {
      return cantDaysExt;
   }

   public void setCantDaysExt(int cantDaysExt) {
      this.cantDaysExt = cantDaysExt;
   }

   public String getPaymentWay() {
      return paymentWay;
   }

   public void setPaymentWay(String paymentWay) {
      this.paymentWay = paymentWay;
   }


   public Date getDeliveryDateCar() {
      return deliveryDateCar;
   }

   public void setDeliveryDateCar(Date deliveryDateCar) {
      this.deliveryDateCar = deliveryDateCar;
   }

   public Double getTotalCost() {
      return totalCost;
   }

   public void setTotalCost(Double totalCost) {
      this.totalCost = totalCost;
   }

   public String getContractorName() {
      return contractorName;
   }

   public void setContractorName(String contractorName) {
      this.contractorName = contractorName;
   }
}
