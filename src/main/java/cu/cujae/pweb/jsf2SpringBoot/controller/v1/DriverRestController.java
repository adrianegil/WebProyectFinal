package cu.cujae.pweb.jsf2SpringBoot.controller.v1;


import cu.cujae.pweb.jsf2SpringBoot.domain.Driver;
import cu.cujae.pweb.jsf2SpringBoot.service.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Indiciamos que es un controlador rest
@RestController
@Api(value = "Api of Driver", description = "EndPoints Driver Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class DriverRestController {

   @Autowired
   private DriverService driverService;

   //    http://127.0.0.1:8080/api/v1/driver/1
   @ApiOperation(value = "", notes = "Return a Driver by his code")
   @GetMapping("/driver/{driverCod}")
   public Driver getDriver(@PathVariable Long driverCod) {
      return driverService.findByCod(driverCod);
   }

   //    http://127.0.0.1:8080/api/v1/driver-id/1
   @ApiOperation(value = "", notes = "Return a Driver by his code")
   @GetMapping("/driver-id/{driverCod}")
   public Optional<Driver> getDriverList(@PathVariable Long driverCod) {
      return driverService.findById(driverCod);
   }

   //    http://127.0.0.1:8080/api/v1/driver
   @ApiOperation(value = "", notes = "Return All Drivers")
   @GetMapping("/driver")
   public List<Driver> findAll() {
      return driverService.findAll();
   }

   //    http://127.0.0.1:8080/api/v1/driver-available
   @ApiOperation(value = "", notes = "Return All Available Drivers")
   @GetMapping("/driver-available")
   public List<Driver> findAllAvailable() {
      return driverService.findAllAvailable();
   }

   //    http://127.0.0.1:8080/api/v1/driver-count
   @ApiOperation(value = "", notes = "Return Total Drivers count")
   @GetMapping("/driver-count")
   public int count() {
      return driverService.count();
   }

   //    http://127.0.0.1:8080/api/v1/driver/3
   @ApiOperation(value = "", notes = "Delete a Driver by his code")
   @DeleteMapping("driver/{driverCod}")
   public int deteteDriver(@PathVariable Long driverCod) {
      return driverService.delete(driverCod);
   }

   //http://127.0.0.1:8080/api/v1/driver/
   @ApiOperation(value = "", notes = "Insert a Driver in the system")
   @PostMapping("/driver")
   public int saveDriver(@RequestBody Driver driver) {
      return driverService.save(driver);
   }

   //http://127.0.0.1:8080/api/v1/driver/
   @ApiOperation(value = "", notes = "Update a Driver in the system")
   @PutMapping("/driver")
   public int updateDriver(@RequestBody Driver driver) {
      return driverService.update(driver);
   }
}
