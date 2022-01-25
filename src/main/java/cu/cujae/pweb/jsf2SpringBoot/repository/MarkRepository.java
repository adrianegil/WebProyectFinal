package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;

import java.util.List;

public interface MarkRepository {

   Mark findByCod(Long cod);

   List<Mark> findAll();
}
