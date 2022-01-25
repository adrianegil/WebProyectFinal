package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Rate;
import cu.cujae.pweb.jsf2SpringBoot.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RateServiceImpl implements RateService {

   @Autowired
   private RateRepository rateRepository;

   @Override
   @Transactional(readOnly = true)
   public Rate findByCod(Long cod) {
      return rateRepository.findByCod(cod);
   }
}
