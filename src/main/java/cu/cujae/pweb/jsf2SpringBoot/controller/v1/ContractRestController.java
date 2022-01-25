package cu.cujae.pweb.jsf2SpringBoot.controller.v1;

import cu.cujae.pweb.jsf2SpringBoot.domain.Contract;
import cu.cujae.pweb.jsf2SpringBoot.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Api of Contract", description = "EndPoints Contract Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class ContractRestController {

   @Autowired
   private ContractService contractService;

   //    http://127.0.0.1:8080/api/v1/contract
   @ApiOperation(value = "", notes = "Return All Contracts")
   @GetMapping("/contract")
   public List<Contract> findAll() {
      return contractService.findAll();
   }

   //    http://127.0.0.1:8080/api/v1/contract-count
   @ApiOperation(value = "", notes = "Return Total Contracts count")
   @GetMapping("/contract-count")
   public int count() {
      return contractService.count();
   }

   //http://127.0.0.1:8080/api/v1/contractCod/3
   @ApiOperation(value = "", notes = "Delete a Contract by its code")
   @DeleteMapping("contract/{contractCod}")
   public int deteteContract(@PathVariable Long contractCod) {
      return contractService.delete(contractCod);
   }

   //http://127.0.0.1:8080/api/v1/contract/
   @ApiOperation(value = "", notes = "Insert a Contract in the system")
   @PostMapping("/contract")
   public int saveContract(@RequestBody Contract contract) {
      return contractService.save(contract);
   }

   //http://127.0.0.1:8080/api/v1/contract/
   @ApiOperation(value = "", notes = "Update a Contract in the system")
   @PutMapping("/contract")
   public int updateContract(@RequestBody Contract contract) {
      return contractService.update(contract);
   }
}
