package cu.cujae.pweb.jsf2SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cu.cujae.pweb.jsf2SpringBoot.domain.User;
import cu.cujae.pweb.jsf2SpringBoot.repository.IUserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

   @Autowired
   private IUserRepository userRepository;

   @Override
   public int count() {
      int cout = userRepository.count();
      return cout;
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<User> findById(Long id) {
      return userRepository.findById(id);
   }

   @Override
   public int save(User user) {

      return userRepository.save(user);
   }

   @Override
   public int update(User user) {
      return userRepository.update(user);
   }

   @Override
   public int delete(Long id) {
      return userRepository.deleteById(id);
   }

   @Override
   public List<User> findAll() {
      List<User> listUsers = userRepository.findAll();
      return listUsers;
   }

   @Override
   public List<User> findByAttribute(String username, String full_name, String email) {
      List<User> listUsers = userRepository.findByAttribute(username, full_name, email);
      return listUsers;
   }

   @Override
   public User findByUserName(String username) {
      return userRepository.findByUserName(username);
   }
}
