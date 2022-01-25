package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Country;
import cu.cujae.pweb.jsf2SpringBoot.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

   @Autowired
   private CountryRepository countryRepository;

   @Override
   @Transactional(readOnly = true)
   public Country findByCod(Long cod) {
      return countryRepository.findByCod(cod);
   }

   @Override
   public List<Country> findAll() {
      return countryRepository.findAll();
   }
}
