package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Rate;

public interface RateRepository {

   Rate findByCod(Long cod);

   int save(Rate rate);

   Rate findByRate(double cost, double specialcost);
}
