package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Tourist;

import java.util.List;

public interface TouristService {

   int count();

   List<Tourist> findAll();

   int delete(Long cod);

   Tourist findByCod(Long cod);

   int save(Tourist tourist);

   int update(Tourist tourist);
}
