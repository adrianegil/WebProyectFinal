package cu.cujae.pweb.jsf2SpringBoot.controller.v1;


import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;
import cu.cujae.pweb.jsf2SpringBoot.service.MarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Api of Mark", description = "EndPoints Mark Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class MarkRestController {

   @Autowired
   private MarkService markService;

   //    http://127.0.0.1:8080/api/v1/mark
   @ApiOperation(value = "", notes = "Return All Marks")
   @GetMapping("/mark")
   public List<Mark> findAll() {
      return markService.findAll();
   }
}
