package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cu.cujae.pweb.jsf2SpringBoot.domain.User;

@ManagedBean(name = "viewHelperBean")
@ViewScoped
public class ViewHelperBean {
   private static User userSelected;

   public ViewHelperBean() {
      userSelected = new User();
   }

   public static User getUserSelected() {
      return userSelected;
   }

   public static void setUserSelected(User userSelected) {
      ViewHelperBean.userSelected = userSelected;
   }
}
