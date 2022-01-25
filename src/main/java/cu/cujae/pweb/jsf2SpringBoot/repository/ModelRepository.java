package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Model;

import java.util.List;

public interface ModelRepository {


   Model findByCod(Long cod);

   List<Model> findAllbyMarkCod(long cod);

   List<Model> findAll();
}
