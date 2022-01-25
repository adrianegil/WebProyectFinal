package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Model;

import java.util.List;

public interface ModelService {

   Model findByCod(Long cod);

   List<Model> findAllbyMarkCod(long cod);

   List<Model> findAll();
}
