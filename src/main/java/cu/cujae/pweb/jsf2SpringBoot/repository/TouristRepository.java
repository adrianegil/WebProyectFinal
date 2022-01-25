package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Tourist;

import java.util.List;

public interface TouristRepository {

   int count();

   List<Tourist> findAll();

   int deleteByCod(Long cod);

   Tourist findByCod(Long cod);

   int save(Tourist tourist);

   int update(Tourist tourist);
}
