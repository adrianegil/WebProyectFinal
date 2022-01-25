package cu.cujae.pweb.jsf2SpringBoot.security.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.web.WebAttributes;
import cu.cujae.pweb.jsf2SpringBoot.util.JsfUtils;

public class LoginErrorPhaseListener implements PhaseListener {

   private static final long serialVersionUID = 1L;

   @Override
   public void afterPhase(PhaseEvent arg0) {

   }

   @Override
   public void beforePhase(PhaseEvent arg0) {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      Exception exception = (Exception) externalContext.getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
      if (exception != null) {
         externalContext.getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
         FacesContext.getCurrentInstance().addMessage("securityMessages", new FacesMessage(FacesMessage.SEVERITY_ERROR, JsfUtils.getStringValueFromBundle(AuthenticationUtils.getErrorMessagesSpringSecurity(exception)), null));
      }
   }

   @Override
   public PhaseId getPhaseId() {
      return PhaseId.RENDER_RESPONSE;
   }
}
