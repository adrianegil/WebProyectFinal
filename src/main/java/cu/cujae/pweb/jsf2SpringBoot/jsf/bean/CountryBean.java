package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;

import cu.cujae.pweb.jsf2SpringBoot.domain.Country;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "request")
@Component(value = "countryBean")
@ELBeanName(value = "countryBean")
public class CountryBean {

   @Autowired
   private RestService restService;

   private List<Country> countryList;
   private Country country;

   public CountryBean() {
      countryList = new ArrayList<>();
      country = new Country();
   }

   public List<Country> getCountryList() throws IOException {
      ApiRestMapper<Country> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/country", null, String.class).getBody();
      return apiRestMapper.mapList(response, Country.class);
   }

   public void setCountryList(List<Country> countryList) {
      this.countryList = countryList;
   }

   public Country getCountry() {
      return country;
   }

   public void setCountry(Country country) {
      this.country = country;
   }
}
