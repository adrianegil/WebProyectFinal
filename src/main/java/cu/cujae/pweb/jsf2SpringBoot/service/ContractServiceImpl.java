package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Contract;
import cu.cujae.pweb.jsf2SpringBoot.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

   @Autowired
   private ContractRepository contractRepository;

   @Override
   public int count() {
      return contractRepository.count();
   }

   @Override
   public List<Contract> findAll() {
      return contractRepository.findAll();
   }

   @Override
   public int delete(Long cod) {
      return contractRepository.deleteByCod(cod);
   }

   @Override
   public int save(Contract contract) {
      return contractRepository.save(contract);
   }

   @Override
   public int update(Contract contract) {
      return contractRepository.update(contract);
   }
}
