package cu.cujae.pweb.jsf2SpringBoot.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cu.cujae.pweb.jsf2SpringBoot.domain.Role;
import cu.cujae.pweb.jsf2SpringBoot.domain.User;
import cu.cujae.pweb.jsf2SpringBoot.service.IUserService;

public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
   private IUserService userService;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      //String pass = new BCryptPasswordEncoder().encode("password");

      User user = userService.findByUserName(username);
      Collection<String> roleNames = user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList());
      UserDetailsImpl userDetails = null;
      if (user != null) {
         userDetails = new UserDetailsImpl();
         ((UserDetailsImpl) userDetails).setUsername(user.getUsername());
         ((UserDetailsImpl) userDetails).setPassword(user.getPassword());
         ((UserDetailsImpl) userDetails).setFullName(user.getFullname());
         ((UserDetailsImpl) userDetails).setEmail(user.getEmail());
         ((UserDetailsImpl) userDetails).setEnabled(true);
         ((UserDetailsImpl) userDetails).setLocale("es");
         ((UserDetailsImpl) userDetails).setAuthorities(AuthorityUtils.createAuthorityList(roleNames.toArray(new String[0])));
      } else
         throw new BadCredentialsException("User not found.");

      return userDetails;
   }
}