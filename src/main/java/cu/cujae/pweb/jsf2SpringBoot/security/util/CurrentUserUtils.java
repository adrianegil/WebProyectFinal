package cu.cujae.pweb.jsf2SpringBoot.security.util;

import org.springframework.security.core.context.SecurityContextHolder;

import cu.cujae.pweb.jsf2SpringBoot.security.UserDetailsImpl;

public class CurrentUserUtils {

   public CurrentUserUtils() {
      super();
   }

   private static final String ANONYMOUS_USER = "anonymousUser";

   public static UserDetailsImpl getUserDetails() {
      return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
   }

   public static String getUsername() {
      String username = null;
      if (SecurityContextHolder.getContext().getAuthentication() != null) {
         username = SecurityContextHolder.getContext().getAuthentication().getName();
      }
      return username;
   }

   public static String getLocale() {
      String locale = null;
      if (isLogged()) {
         locale = getUserDetails().getLocale();
      }
      return locale;
   }

   public static String getFullName() {
      String fullName = null;
      if (isLogged()) {
         fullName = getUserDetails().getFullName();
      }
      return fullName;
   }

   public static boolean isLogged() {
      boolean logged = false;
      if ((SecurityContextHolder.getContext().getAuthentication() != null) && (!getUsername().equals(ANONYMOUS_USER))) {
         logged = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
      }
      return logged;
   }

   public static String getPassword() {
      String password = null;
      if (isLogged()) {
         password = getUserDetails().getPassword()/*(String) SecurityContextHolder.getContext().getAuthentication().getCredentials()*/;
      }
      return password;
   }
}
