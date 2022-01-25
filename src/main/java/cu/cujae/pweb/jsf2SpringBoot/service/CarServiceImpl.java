package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Car;
import cu.cujae.pweb.jsf2SpringBoot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

   @Autowired
   private CarRepository carRepository;


   @Override
   public int count() {
      return carRepository.count();
   }

   @Override
   public List<Car> findAll() {
      return carRepository.findAll();
   }

   @Override
   public List<Car> findAllAvailable() {
      return carRepository.findAllAvailable();
   }

   @Override
   public int delete(Long cod) {
      return carRepository.deleteByCod(cod);
   }

   @Override
   @Transactional(readOnly = true)
   public Car findByCod(Long cod) {
      return carRepository.findByCod(cod);
   }

   @Override
   public int save(Car car) {
      return carRepository.save(car);
   }

   @Override
   public int update(Car car) {
      return carRepository.update(car);
   }
}
