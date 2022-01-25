package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Driver {

   private long drivCod;
   private String drivId;
   private String drivName;
   private String drivLastName;
   private String drivAddress;
   private String drivCat;
   private boolean available;
   private String email;

   @Override
   public String toString() {
      return drivName + " " + drivLastName;
   }

   public Driver() {

   }

   public Driver(long drivCod, String drivId, String drivName, String drivLastName, String drivAddress, String drivCat, boolean available, String email) {
      this.drivCod = drivCod;
      this.drivId = drivId;
      this.drivName = drivName;
      this.drivLastName = drivLastName;
      this.drivAddress = drivAddress;
      this.drivCat = drivCat;
      this.available = available;
      this.email = email;
   }

   public long getDrivCod() {
      return drivCod;
   }

   public void setDrivCod(long drivCod) {
      this.drivCod = drivCod;
   }

   public String getDrivId() {
      return drivId;
   }

   public void setDrivId(String drivId) {
      this.drivId = drivId;
   }

   public String getDrivName() {
      return drivName;
   }

   public void setDrivName(String drivName) {
      this.drivName = drivName;
   }

   public String getDrivLastName() {
      return drivLastName;
   }

   public void setDrivLastName(String drivLastName) {
      this.drivLastName = drivLastName;
   }

   public String getDrivAddress() {
      return drivAddress;
   }

   public void setDrivAddress(String drivAddress) {
      this.drivAddress = drivAddress;
   }

   public String getDrivCat() {
      return drivCat;
   }

   public void setDrivCat(String drivCat) {
      this.drivCat = drivCat;
   }

   public boolean isAvailable() {
      return available;
   }

   public void setAvailable(boolean available) {
      this.available = available;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
