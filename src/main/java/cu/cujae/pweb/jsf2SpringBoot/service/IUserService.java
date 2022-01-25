package cu.cujae.pweb.jsf2SpringBoot.service;

import java.util.List;
import java.util.Optional;

import cu.cujae.pweb.jsf2SpringBoot.domain.User;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

   int count();

   List<User> findAll();

   User findByUserName(String username);

   @Transactional(readOnly = true)
   Optional<User> findById(Long id);

   int save(User user);

   int update(User user);

   int delete(Long id);

   List<User> findByAttribute(String username, String full_name, String email);
}
