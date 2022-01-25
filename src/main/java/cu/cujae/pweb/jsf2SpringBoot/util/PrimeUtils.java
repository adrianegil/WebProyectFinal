package cu.cujae.pweb.jsf2SpringBoot.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;

public class PrimeUtils {
   /**
    * Metodo para borrar el segundo tab activo de Primefaces
    *
    * @param tab
    */
   public static void deleteSecondTab(TabView tabView) {
      if (tabView.getChildren().size() == 2) {
         tabView.getChildren().remove(1);
         tabView.setActiveIndex(0);
      }
   }

   /**
    * Crear nuevo tab
    *
    * @param tabView   Componente Tab
    * @param tabTitle  El title para el Tab que se abre nuevo
    * @param pathView  El camino a la vista nueva
    * @param tabViewId El identificador del tab
    * @return
    * @throws IOException
    */
   public static int createTab(TabView tabView, String tabTitle, String pathView, String tabViewId) throws IOException {
      Tab newTab = new Tab();
      newTab.setClosable(true);
      newTab.setTitle(tabTitle); //insertando
      FaceletContext faceletContext = (FaceletContext) FacesContext.getCurrentInstance().getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);
      faceletContext.includeFacelet(newTab, pathView);
      PrimeUtils.deleteSecondTab(tabView);
      tabView.getChildren().add(newTab);
      PrimeFaces.current().ajax().update(tabViewId);
      return 1;
   }

   /**
    * Permite validar un email.
    *
    * @param email
    * @return
    */
   public static boolean isValidEmail(String email) {
      boolean isValid = false;
      Pattern p = Pattern
              .compile("[a-zA-Z0-9][a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+");
      Matcher m = p.matcher(email);
      isValid = m.matches();
      return isValid;
   }
}
