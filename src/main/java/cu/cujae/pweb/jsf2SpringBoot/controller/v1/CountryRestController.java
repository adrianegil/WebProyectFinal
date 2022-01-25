package cu.cujae.pweb.jsf2SpringBoot.controller.v1;

import cu.cujae.pweb.jsf2SpringBoot.domain.Country;
import cu.cujae.pweb.jsf2SpringBoot.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Api of Country", description = "EndPoints Country Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class CountryRestController {

   @Autowired
   private CountryService countryService;

   //http://127.0.0.1:8080/api/v1/country/1
   @ApiOperation(value = "", notes = "Return a Country by its code")
   @GetMapping("/country/{countryCod}")
   public Country getCountry(@PathVariable Long countryCod) {
      return countryService.findByCod(countryCod);
   }

   //    http://127.0.0.1:8080/api/v1/car
   @ApiOperation(value = "", notes = "Return All Countries")
   @GetMapping("/country")
   public List<Country> findAll() {
      return countryService.findAll();
   }
}
