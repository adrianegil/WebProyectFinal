package cu.cujae.pweb.jsf2SpringBoot.controller.v1;

import cu.cujae.pweb.jsf2SpringBoot.domain.Car;
import cu.cujae.pweb.jsf2SpringBoot.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Api of Car", description = "EndPoints Car Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/v1
public class CarRestController {

   @Autowired
   private CarService carService;

   //http://127.0.0.1:8080/api/v1/model/1
   @ApiOperation(value = "", notes = "Return a Car by its code")
   @GetMapping("/car/{carCod}")
   public Car getCar(@PathVariable Long carCod) {
      return carService.findByCod(carCod);
   }

   //    http://127.0.0.1:8080/api/v1/car
   @ApiOperation(value = "", notes = "Return All Cars")
   @GetMapping("/car")
   public List<Car> findAll() {
      return carService.findAll();
   }

   //    http://127.0.0.1:8080/api/v1/car-available
   @ApiOperation(value = "", notes = "Return All Available Cars")
   @GetMapping("/car-available")
   public List<Car> findAllAvailable() {
      return carService.findAllAvailable();
   }

   //    http://127.0.0.1:8080/api/v1/car-count
   @ApiOperation(value = "", notes = "Return the Total Cars count")
   @GetMapping("/car-count")
   public int count() {
      return carService.count();
   }

   //http://127.0.0.1:8080/api/v1/car/3
   @ApiOperation(value = "", notes = "Delete a Car by its code")
   @DeleteMapping("car/{carCod}")
   public int deteteCar(@PathVariable Long carCod) {
      return carService.delete(carCod);
   }

   //http://127.0.0.1:8080/api/v1/car/
   @ApiOperation(value = "", notes = "Insert a Car in the system")
   @PostMapping("/car")
   public int saveCar(@RequestBody Car car) {
      return carService.save(car);
   }

   //http://127.0.0.1:8080/api/v1/car/
   @PutMapping("/car")
   @ApiOperation(value = "", notes = "Update a Car in the system")
   public int updateCar(@RequestBody Car car) {
      return carService.update(car);
   }
}
