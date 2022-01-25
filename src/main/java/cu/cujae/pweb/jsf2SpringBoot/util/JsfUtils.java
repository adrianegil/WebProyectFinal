package cu.cujae.pweb.jsf2SpringBoot.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JsfUtils {

   private static Properties properties = null;

   public static void addMessage(String componentId, Severity severity, String summary) {
      addMessage(componentId, severity, summary, null);
   }

   public static void addMessage(String componentId, Severity severity, String... msgs) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      FacesMessage message = new FacesMessage(severity, msgs[0], msgs[1]);
      facesContext.addMessage(componentId, message);
   }

   public static void addMessageFromBundle(String componentId, Severity severity, String summaryKey) {
      addMessage(componentId, severity, getStringValueFromBundle(summaryKey), null);
   }

   public static void addMessageFromBundle(String componentId, Severity severity, String summaryKey, String param) {
      addMessage(componentId, severity, MessageFormat.format(getStringValueFromBundle(summaryKey), param), null);
   }

   public static void addMessageFromBundle(String componentId, Severity severity, String... keys) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      FacesMessage message = new FacesMessage(severity, getStringValueFromBundle(keys[0]), getStringValueFromBundle(keys[1]));
      facesContext.addMessage(componentId, message);
   }

   public static String getStringValueFromBundle(String key) {
      return ResourceBundle.getBundle("i18n.messages", getCurrentLocale()).getString(key);
   }

   public static Object getComponentValue(String id) {
      Object value = null;
      UIInput component = (UIInput) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
      if (component != null) {
         value = component.getValue();
      }
      return value;
   }

   public static String getRequestParameter(String key) {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      return externalContext.getRequestParameterMap().get(key);
   }

   public static void setRequestParameter(String key, Object value) {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      externalContext.getRequestParameterMap().put(key, value.toString());
   }

   public static HttpServletRequest getRequest() {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
      return request;
   }

   public static HttpSession getSession() {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      HttpSession session = (HttpSession) externalContext.getSession(false);
      return session;
   }

   public static HttpServletResponse getResponse() {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
      return response;
   }

   public static void setSessionParameter(String key, Object value) {
      getSession().setAttribute(key, value);
   }

   public static Object getSessionParameter(String key) {
      return getSession().getAttribute(key);
   }

   public static void removeSessionParameter(String key) {
      getSession().removeAttribute(key);
   }

   //OJO: Si la aplicacion esta detras de un firewall utilizar
   //Este metdo request.getHeader("x-forwarded-for") en lugar de getRemoteAddr
   public static String getRemoteIpAddress() {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
      return request.getRemoteAddr();
   }

   public static FacesContext getFacesContext() {
      FacesContext context = FacesContext.getCurrentInstance();
      return context;
   }

   public static Locale getCurrentLocale() {
      return FacesContext.getCurrentInstance().getViewRoot().getLocale();
   }

   public static Object resolverBean(String beanName) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      return facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, beanName);
   }

   public static String getBasePath(String path) {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      return externalContext.getRealPath(path);
   }
}
