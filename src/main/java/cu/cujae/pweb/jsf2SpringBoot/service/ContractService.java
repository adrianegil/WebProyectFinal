package cu.cujae.pweb.jsf2SpringBoot.service;

import cu.cujae.pweb.jsf2SpringBoot.domain.Contract;

import java.util.List;

public interface ContractService {

   int count();

   List<Contract> findAll();

   int delete(Long cod);

   int save(Contract contract);

   int update(Contract contract);
}
