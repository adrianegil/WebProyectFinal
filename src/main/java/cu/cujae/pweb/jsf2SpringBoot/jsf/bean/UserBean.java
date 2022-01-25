package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sun.org.apache.xml.internal.security.Init;
import cu.cujae.pweb.jsf2SpringBoot.domain.Mail;
import cu.cujae.pweb.jsf2SpringBoot.repository.RateRepository;
import cu.cujae.pweb.jsf2SpringBoot.repository.RoleRepository;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabCloseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import cu.cujae.pweb.jsf2SpringBoot.domain.User;
import cu.cujae.pweb.jsf2SpringBoot.security.UserDetailsImpl;
import cu.cujae.pweb.jsf2SpringBoot.security.util.CurrentUserUtils;
import cu.cujae.pweb.jsf2SpringBoot.service.IUserService;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.JsfUtils;
import cu.cujae.pweb.jsf2SpringBoot.util.PrimeUtils;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;

@Scope(value = "request")
@Component(value = "userBean")
@ELBeanName(value = "userBean")
public class UserBean {

   @Autowired
   private RestService restService;

   @Autowired
   private IUserService userService;

   @Autowired
   RoleRepository roleRepository;

   private List<User> userList;
   private List<User> usersFiltered;
   private User user; // usado como modelo en las operaciones POST, cambiar contraseña...
   private User selectedUser; // usado como modelo al seleccionarlo de una lista o tabla, PUT, DELETE...

   private String userLogged;
   private String userNameLogged;
   private String userEmail;

   public UserBean() throws IOException {

      userList = new ArrayList<>();
      usersFiltered = new ArrayList<>();
      user = new User();
      selectedUser = new User();
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public String save() {

      try {
         if (!user.getPasswordConfirm().equals(user.getPassword())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Datos incorrectos",
                    "No se puede crear el usuario debido a que la contraseña y su confirmación no coinciden."));
            return null;
         }
         user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

         restService.POST("/api/v1/user", user, String.class, null); // solo se inserta la nueva tupla

         User u = userService.findByUserName(user.getUsername());

         for (int i = 0; i < user.getRolesSelected().size(); i++) {

            int res = 0;

            if (user.getRolesSelected().get(i).equals("ROLE_ADMIN")) {

               res = roleRepository.insertRol(u.getId(), 1);
            } else if (user.getRolesSelected().get(i).equals("ROLE_GUEST")) {

               res = roleRepository.insertRol(u.getId(), 2);

            } else {
               res = roleRepository.insertRol(u.getId(), 3);
            }
         }
         Mail mail = new Mail("agil@ceis.cujae.edu.cu", user.getEmail(), "Welcome", "Welcome to RentACar System");
         restService.POST("/api/v1/mail/sendMail", mail, String.class, null);

         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_InsertLarge")));
         return (CurrentUserUtils.isLogged() ? "user/all" : "login");

      } catch (Exception e) {
         e.printStackTrace();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operación fallida", JsfUtils.getStringValueFromBundle("label_operationERROR")));
         return null;
      }
   }

   public String delete() {
      try {
         User current = userService.findByUserName(CurrentUserUtils.getUsername());
         if (selectedUser.getId() != current.getId()) {
            restService.DELETE("/api/v1/user/" + selectedUser.getId(), null, String.class);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_DeleteLarge")));
            return "Ok";
         } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuario actual no eliminable",
                    "No se puede eliminar de esta forma al usuario administrador actualmente autenticado en el sitio."));
            return null;
         }

      } catch (Exception e) {
         e.printStackTrace();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
      return null;
   }

   /*public void update() {

       try {

           restService.PUT("/api/v1/user", null, selectedUser, String.class, null);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_EditLarge")));
           init();

       } catch (Exception e) {

           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));

       }

   }
*/
   public String changePassword() {
      try {

         BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

         UserDetailsImpl userD = CurrentUserUtils.getUserDetails();

         if (bcpe.matches(user.getPassword(), userD.getPassword()) &&
                 user.getPasswordConfirm().equals(user.getPasswordNew())) {
            User user2 = userService.findByUserName(CurrentUserUtils.getUsername());
            user2.setPassword(new BCryptPasswordEncoder().encode(user.getPasswordNew()));
            restService.PUT("/api/v1/user", null, user2, String.class, null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, JsfUtils.getStringValueFromBundle("lbl_OperationOK"), JsfUtils.getStringValueFromBundle("lbl_OperationOK_EditLarge")));

            return "success";

         } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Credenciales incorrectas",
                    "No se puede actualizar la contraseña debido a que la contraseña actual no es "
                            + "la correcta o que la nueva y su confirmación no coinciden."));
            return null;
         }

      } catch (Exception e) {
         e.printStackTrace();
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
      }
      return null;
   }

   public List<User> getUserList() throws IOException {

      ApiRestMapper<User> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/user", null, String.class).getBody();
      return apiRestMapper.mapList(response, User.class);

   }

   public void setUserList(List<User> userList) {
      this.userList = userList;
   }

   public String getUserLogged() {
      userLogged = CurrentUserUtils.getFullName();
      return userLogged;
   }

   public void setUserLogged(String userLogged) {
      this.userLogged = userLogged;
   }

   public User getSelectedUser() {
      return selectedUser;
   }

   public void setSelectedUser(User selectedUser) {
      this.selectedUser = selectedUser;
   }

   public String getUserNameLogged() {
      return CurrentUserUtils.getUsername();
   }

   public void setUserNameLogged(String userNameLogged) {
      this.userNameLogged = userNameLogged;
   }

   public String getUserEmail() {

      User current = userService.findByUserName(CurrentUserUtils.getUsername());

      return current.getEmail();
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }
}
