package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Tourist {

   private long touristCod;
   private long passportNumb;
   private String touristName;
   private String touristLastName;
   private String touristSex;
   private int touristAge;
   private long touristContact;
   private Country touristCountry;
   private String email;

   @Override
   public String toString() {
      return touristName + " " + touristLastName;
   }

   public Tourist() {
      touristCountry = new Country();
   }

   public Tourist(long touristCod, long passportNumb, String touristName, String touristLastName, String touristSex, int touristAge, long touristContact, Country touristCountry, String email) {
      this.touristCod = touristCod;
      this.passportNumb = passportNumb;
      this.touristName = touristName;
      this.touristLastName = touristLastName;
      this.touristSex = touristSex;
      this.touristAge = touristAge;
      this.touristContact = touristContact;
      this.touristCountry = touristCountry;
      this.email = email;
   }

   public long getTouristCod() {
      return touristCod;
   }

   public void setTouristCod(long touristCod) {
      this.touristCod = touristCod;
   }

   public long getPassportNumb() {
      return passportNumb;
   }

   public void setPassportNumb(long passportNumb) {
      this.passportNumb = passportNumb;
   }

   public String getTouristName() {
      return touristName;
   }

   public void setTouristName(String touristName) {
      this.touristName = touristName;
   }

   public String getTouristLastName() {
      return touristLastName;
   }

   public void setTouristLastName(String touristLastName) {
      this.touristLastName = touristLastName;
   }

   public String getTouristSex() {
      return touristSex;
   }

   public void setTouristSex(String touristSex) {
      this.touristSex = touristSex;
   }

   public int getTouristAge() {
      return touristAge;
   }

   public void setTouristAge(int touristAge) {
      this.touristAge = touristAge;
   }

   public long getTouristContact() {
      return touristContact;
   }

   public void setTouristContact(long touristContact) {
      this.touristContact = touristContact;
   }

   public Country getTouristCountry() {
      return touristCountry;
   }

   public void setTouristCountry(Country touristCountry) {
      this.touristCountry = touristCountry;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
