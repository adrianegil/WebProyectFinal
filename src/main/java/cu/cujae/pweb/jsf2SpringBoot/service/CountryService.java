package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Country;

import java.util.List;

public interface CountryService {

   Country findByCod(Long cod);

   List<Country> findAll();
}
