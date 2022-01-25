package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Situation;
import cu.cujae.pweb.jsf2SpringBoot.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SituationServiceImpl implements SituationService {

   @Autowired
   private SituationRepository situationRepository;

   @Override
   @Transactional(readOnly = true)
   public Situation findByCod(Long cod) {
      return situationRepository.findByCod(cod);
   }
}
