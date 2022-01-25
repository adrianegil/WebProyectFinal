package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Contract;

import java.util.List;

public interface ContractRepository {

   int count();

   List<Contract> findAll();

   int deleteByCod(Long cod);

   int save(Contract contract);

   int update(Contract contract);
}
