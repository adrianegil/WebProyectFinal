package cu.cujae.pweb.jsf2SpringBoot.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

   private Long id;
   private String username;
   private String fullname;
   private String email;
   private String password;
   private List<Role> roles;
   private List<String> rolesSelected;
   private String passwordConfirm;
   private String passwordNew;

   public User() {

   }

   public User(Long id, String username, String fullname, String email, String password) {
      this.id = id;
      this.username = username;
      this.fullname = fullname;
      this.email = email;
      this.password = password;
      passwordConfirm = null;
      passwordNew = null;
      rolesSelected = new ArrayList<String>(3);
   }

   public User(Long id, String username, String fullname, String email, List<Role> roles, String password) {
      this.id = id;
      this.username = username;
      this.fullname = fullname;
      this.email = email;
      this.roles = roles;
      this.password = password;
      passwordConfirm = null;
      passwordNew = null;
      rolesSelected = new ArrayList<String>(roles.size() + 1);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public List<Role> getRoles() {
      return roles;
   }

   public void setRoles(List<Role> roles) {
      this.roles = roles;
   }

   public List<String> getRolesSelected() {
      return rolesSelected;
   }

   public void setRolesSelected(List<String> rolesSelected) {
      this.rolesSelected = rolesSelected;
   }

   public String getPasswordConfirm() {
      return passwordConfirm;
   }

   public void setPasswordConfirm(String passwordConfirm) {
      this.passwordConfirm = passwordConfirm;
   }

   public String getPasswordNew() {
      return passwordNew;
   }

   public void setPasswordNew(String passwordNew) {
      this.passwordNew = passwordNew;
   }

   public String getFullname() {
      return fullname;
   }

   public void setFullname(String fullname) {
      this.fullname = fullname;
   }
}
