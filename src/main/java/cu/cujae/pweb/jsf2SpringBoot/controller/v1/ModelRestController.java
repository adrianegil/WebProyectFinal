package cu.cujae.pweb.jsf2SpringBoot.controller.v1;


import cu.cujae.pweb.jsf2SpringBoot.domain.Model;
import cu.cujae.pweb.jsf2SpringBoot.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Api of Model", description = "EndPoints Model Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class ModelRestController {

   @Autowired
   private ModelService modelService;

   //http://127.0.0.1:8080/api/v1/model/1
   @ApiOperation(value = "", notes = "Return a Model by its code")
   @GetMapping("/model/{modelCod}")
   public Model getModel(@PathVariable Long modelCod) {
      return modelService.findByCod(modelCod);
   }

   //    http://127.0.0.1:8080/api/v1/model
   @ApiOperation(value = "", notes = "Return All Models")
   @GetMapping("/model")
   public List<Model> findAll() {
      return modelService.findAll();
   }

   //    http://127.0.0.1:8080/api/v1/model-list/3
   @ApiOperation(value = "", notes = "Return All Models by a Mark's code")
   @GetMapping("/model-list/{markCod}")
   public List<Model> findAllbyMarkCod(@PathVariable Long markCod) {
      return modelService.findAllbyMarkCod(markCod);
   }
}
