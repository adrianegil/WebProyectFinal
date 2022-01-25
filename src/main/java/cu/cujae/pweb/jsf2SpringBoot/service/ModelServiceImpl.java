package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Model;
import cu.cujae.pweb.jsf2SpringBoot.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModelServiceImpl implements ModelService {

   @Autowired
   private ModelRepository modelRepository;

   @Override
   @Transactional(readOnly = true)
   public Model findByCod(Long cod) {
      return modelRepository.findByCod(cod);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Model> findAllbyMarkCod(long cod) {
      return modelRepository.findAllbyMarkCod(cod);
   }

   @Override
   public List<Model> findAll() {
      return modelRepository.findAll();
   }
}
