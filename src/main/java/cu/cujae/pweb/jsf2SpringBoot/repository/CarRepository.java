package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Car;

import java.util.List;

public interface CarRepository {

   int count();

   List<Car> findAll();

   List<Car> findAllAvailable();

   int deleteByCod(Long cod);

   Car findByCod(Long cod);

   int save(Car car);

   int update(Car car);
}
