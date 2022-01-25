package cu.cujae.pweb.jsf2SpringBoot.controller.v1;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cu.cujae.pweb.jsf2SpringBoot.domain.User;
import cu.cujae.pweb.jsf2SpringBoot.service.IUserService;
import cu.cujae.pweb.jsf2SpringBoot.service.UserServiceImpl;

//Indiciamos que es un controlador rest
@RestController
@Api(value = "Api of User", description = "EndPoints User Controller")
@RequestMapping("/api/v1") //esta sera la raiz de la url, es decir http://127.0.0.1:8081/api/v1
public class UserRestController {

   @Autowired
   private IUserService userService;

   // http://127.0.0.1:8081/api/v1/user
   @ApiOperation(value = "", notes = "Return All Users")
   @GetMapping("/user")
   public List<User> findAll() {
      return userService.findAll();
   }

   @GetMapping("/count")
   @ApiOperation(value = "", notes = "Return Total Users count")
   public int count() {
      return userService.count();
   }

   //http://127.0.0.1:8081/api/v1/user/1
   @ApiOperation(value = "", notes = "Return a User by his code")
   @GetMapping("/user/{userId}")
   public Optional<User> getUser(@PathVariable Long userId) {
      return userService.findById(userId);
   }

   //http://127.0.0.1:8081/api/v1/user/
   @ApiOperation(value = "", notes = "Insert a User in the system")
   @PostMapping("/user")
   public int saveUser(@RequestBody User user) {
      return userService.save(user);
   }

   //http://127.0.0.1:8081/api/v1/user/
   @ApiOperation(value = "", notes = "Update a User in the system")
   @PutMapping("/user")
   public int updateUser(@RequestBody User user) {
      return userService.update(user);
   }

   //http://127.0.0.1:8081/api/v1/user/3
   @ApiOperation(value = "", notes = "Delete a User by his code")
   @DeleteMapping("user/{userId}")
   public int deteteUser(@PathVariable Long userId) {
      return userService.delete(userId);
   }

   // http://127.0.0.1:8081/api/v1/user?username=&full_name=&email=
   @RequestMapping(value = "user", params = {"username", "full_name", "email"}, method = RequestMethod.GET)
   @ResponseBody
   public List<User> findByAttributes(@RequestParam("username") String username,
                                      @RequestParam("full_name") String full_name,
                                      @RequestParam("email") String email) {
      return userService.findByAttribute(username, full_name, email);
   }
}
