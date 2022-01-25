package cu.cujae.pweb.jsf2SpringBoot.security.util;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;

public class AuthenticationUtils {
   /**
    * Retorna la llave del mensaje de error correspondiente al error de acceso que ocurra en cada caso.
    *
    * @param exception
    * @return
    */
   public static String getErrorMessagesSpringSecurity(Exception exception) {
      String key = null;
      if (exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
         key = "error_CredencialesInvalidas";
      } else if (exception instanceof LockedException) {
         key = "error_UsuarioBloqueado";
      } else if (exception instanceof DisabledException) {
         key = "error_UsuarioDeshabilitado";
      } else if (exception instanceof AccountExpiredException) {
         key = "error_CuentaExpired";
      } else if (exception instanceof CredentialsExpiredException) {
         key = "error_CredencialesExperid";
      }
      return key;
   }
}
