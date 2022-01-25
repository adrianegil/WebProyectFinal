package cu.cujae.pweb.jsf2SpringBoot.controller.v1;


import cu.cujae.pweb.jsf2SpringBoot.domain.Tourist;
import cu.cujae.pweb.jsf2SpringBoot.service.TouristService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indiciamos que es un controlador rest
@RestController
@Api(value = "Api of Tourist", description = "EndPoints Tourist Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class TouristRestController {

   @Autowired
   private TouristService touristService;

   //http://127.0.0.1:8080/api/v1/tourist/1
   @ApiOperation(value = "", notes = "Return a Tourist by his code")
   @GetMapping("/tourist/{touristCod}")
   public Tourist getTourist(@PathVariable Long touristCod) {
      return touristService.findByCod(touristCod);
   }

   //    http://127.0.0.1:8080/api/v1/tourist
   @ApiOperation(value = "", notes = "Return All Tourist")
   @GetMapping("/tourist")
   public List<Tourist> findAll() {
      return touristService.findAll();
   }

   //    http://127.0.0.1:8080/api/v1/tourist-count
   @ApiOperation(value = "", notes = "Return Total Tourist count")
   @GetMapping("/tourist-count")
   public int count() {
      return touristService.count();
   }

   //http://127.0.0.1:8080/api/v1/tourist/3
   @ApiOperation(value = "", notes = "Delete a Tourist by his code")
   @DeleteMapping("tourist/{touristCod}")
   public int deteteTourist(@PathVariable Long touristCod) {
      return touristService.delete(touristCod);
   }

   //http://127.0.0.1:8080/api/v1/tourist/
   @ApiOperation(value = "", notes = "Insert a Tourist in the system")
   @PostMapping("/tourist")
   public int saveTourist(@RequestBody Tourist tourist) {
      return touristService.save(tourist);
   }

   //http://127.0.0.1:8080/api/v1/tourist/
   @ApiOperation(value = "", notes = "Update a Tourist by in the system")
   @PutMapping("/tourist")
   public int updateTourist(@RequestBody Tourist tourist) {
      return touristService.update(tourist);
   }
}
