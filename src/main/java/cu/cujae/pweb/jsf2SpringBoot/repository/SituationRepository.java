package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Situation;

public interface SituationRepository {

   Situation findByCod(Long cod);
}
