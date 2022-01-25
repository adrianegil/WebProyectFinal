package cu.cujae.pweb.jsf2SpringBoot.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

   private static final long serialVersionUID = 1L;

   private String username;

   private String password;

   private String fullName;

   private String firstName;

   private String lastName;

   private String email;

   private boolean enabled;

   private String locale;

   private String timezone;

   private Collection<GrantedAuthority> authorities;

   @Override
   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   @Override
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   @Override
   public boolean isEnabled() {
      return enabled;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   @Override
   public Collection<GrantedAuthority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Collection<GrantedAuthority> authorities) {
      this.authorities = authorities;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   public List<String> getAuthorityNames() {
      List<String> authorityNames = new ArrayList<String>();
      for (GrantedAuthority authority : authorities) {
         authorityNames.add(authority.getAuthority());
      }
      return authorityNames;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
}
