package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Car;

import java.util.List;

public interface CarService {

   int count();

   List<Car> findAll();

   List<Car> findAllAvailable();

   int delete(Long cod);

   Car findByCod(Long cod);

   int save(Car car);

   int update(Car car);
}
