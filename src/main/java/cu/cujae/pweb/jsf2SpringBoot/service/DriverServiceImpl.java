package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Driver;
import cu.cujae.pweb.jsf2SpringBoot.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

   @Autowired
   private DriverRepository driverRepository;

   @Override
   public int count() {
      return driverRepository.count();
   }

   @Override
   public List<Driver> findAll() {
      return driverRepository.findAll();
   }

   @Override
   public List<Driver> findAllAvailable() {
      return driverRepository.findAllAvailable();
   }

   @Override
   public int delete(Long cod) {
      return driverRepository.deleteByCod(cod);
   }

   @Override
   @Transactional(readOnly = true)
   public Driver findByCod(Long cod) {
      return driverRepository.findByCod(cod);
   }

   @Override
   public int save(Driver driver) {
      return driverRepository.save(driver);
   }

   @Override
   public int update(Driver driver) {
      return driverRepository.update(driver);
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<Driver> findById(Long id) {
      return driverRepository.findById(id);
   }
}
