package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Country;

import java.util.List;

public interface CountryRepository {

   Country findByCod(Long cod);

   List<Country> findAll();
}
