package cu.cujae.pweb.jsf2SpringBoot.config;

import com.google.common.collect.ImmutableMap;
import cu.cujae.pweb.jsf2SpringBoot.scope.ViewScope;
import cu.cujae.pweb.jsf2SpringBoot.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Bean
   public UserDetailsService userDetailsService() {
      return new UserDetailsServiceImpl();
   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      // require all requests to be authenticated except for the resources
      http.authorizeRequests().antMatchers("/javax.faces.resource/**", "/api/**")
              .permitAll().anyRequest().authenticated();
      // login
      http.formLogin().
              loginPage("/login").permitAll()
              .failureUrl("/login")
              .defaultSuccessUrl("/welcome")
              .and().exceptionHandling().accessDeniedPage("/access-denied");
      // logout
      http.logout().logoutSuccessUrl("/login");
      // not needed as JSF 2.2 is implicitly protected against CSRF
      http.csrf().disable().httpBasic();
   }

   @Bean
   public static CustomScopeConfigurer viewScope() {
      CustomScopeConfigurer configurer = new CustomScopeConfigurer();
      configurer.setScopes(
              new ImmutableMap.Builder<String, Object>().put("view", new ViewScope()).build());
      return configurer;
   }
}
