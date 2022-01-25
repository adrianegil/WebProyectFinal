package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Country {

   private Long countyCod;
   private String countryName;

   public Country() {
   }

   public Country(Long countyCod, String countryName) {
      this.countyCod = countyCod;
      this.countryName = countryName;
   }

   public Long getCountyCod() {
      return countyCod;
   }

   public void setCountyCod(Long countyCod) {
      this.countyCod = countyCod;
   }

   public String getCountryName() {
      return countryName;
   }

   public void setCountryName(String countryName) {
      this.countryName = countryName;
   }
}
