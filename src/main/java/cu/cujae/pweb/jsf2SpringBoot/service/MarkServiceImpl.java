package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;
import cu.cujae.pweb.jsf2SpringBoot.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

   @Autowired
   private MarkRepository markRepository;

   @Override
   @Transactional(readOnly = true)
   public Mark findByCod(Long cod) {
      return markRepository.findByCod(cod);
   }

   @Override
   public List<Mark> findAll() {
      return markRepository.findAll();
   }
}
