package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;

import java.util.List;

public interface MarkService {

   Mark findByCod(Long cod);

   List<Mark> findAll();
}
