package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverRepository {

   int count();

   List<Driver> findAll();

   List<Driver> findAllAvailable();

   int deleteByCod(Long cod);

   Driver findByCod(Long cod);

   int save(Driver driver);

   int update(Driver driver);

   Optional<Driver> findById(Long id);
}
