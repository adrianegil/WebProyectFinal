package cu.cujae.pweb.jsf2SpringBoot.repository;

import java.util.List;
import java.util.Optional;

import cu.cujae.pweb.jsf2SpringBoot.domain.Role;
import cu.cujae.pweb.jsf2SpringBoot.domain.User;

public interface IUserRepository {

   int count();

   Optional<User> findById(Long id);

   User findByUserName(String name);

   int save(User user);

   int update(User user);

   int deleteById(Long id);

   List<User> findAll();

   List<Role> findRolesByUserId(Long id);

   List<User> findByAttribute(String username, String full_name, String email);
}
