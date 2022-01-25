package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Tourist;
import cu.cujae.pweb.jsf2SpringBoot.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TouristServiceImpl implements TouristService {

   @Autowired
   private TouristRepository touristRepository;

   @Override
   public int count() {
      return touristRepository.count();
   }

   @Override
   public List<Tourist> findAll() {
      return touristRepository.findAll();
   }

   @Override
   public int delete(Long cod) {
      return touristRepository.deleteByCod(cod);
   }

   @Override
   @Transactional(readOnly = true)
   public Tourist findByCod(Long cod) {
      return touristRepository.findByCod(cod);
   }

   @Override
   public int save(Tourist tourist) {
      return touristRepository.save(tourist);
   }

   @Override
   public int update(Tourist tourist) {
      return touristRepository.update(tourist);
   }
}
