package cu.cujae.pweb.jsf2SpringBoot.urlrewrite;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;


@RewriteConfiguration
public class UrlRewriteConfigurationProvider extends HttpConfigurationProvider {

   @Override
   public Configuration getConfiguration(ServletContext context) {
      return ConfigurationBuilder.begin()

              //Generals
              .addRule(Join.path("/welcome").to("/pages/welcome/welcome.jsf"))
              .addRule(Join.path("/index").to("/pages/welcome/welcome.jsf"))
              .addRule(Join.path("/home").to("/pages/welcome/welcome.jsf"))

              .addRule(Join.path("/login").to("/pages/security/login.jsf"))

              .addRule(Join.path("/404").to("/pages/404.jsf"))
              .addRule(Join.path("/access-denied").to("/pages/access-denied.jsf"))
              .addRule(Join.path("/error").to("/pages/error.jsf"))

              .addRule(Join.path("/user/all").to("/pages/security/users.jsf"))
              .addRule(Join.path("/user/create").to("/pages/security/createUser.jsf"))
              .addRule(Join.path("/change-password").to("/pages/security/change-password.jsf"))
              .addRule(Join.path("/security-users").to("/pages/security/users.jsf"))
              .addRule(Join.path("/welcome").to("/pages/welcome/welcome.jsf"))
              .addRule(Join.path("/login").to("/pages/security/login.jsf"))
              .addRule(Join.path("/otro").to("/pages/security/otro.jsf"))
              .addRule(Join.path("/car-list").to("/pages/security/car-list.jsf"))
              .addRule(Join.path("/driver-list").to("/pages/security/driver-list.jsf"))
              .addRule(Join.path("/tourist-list").to("/pages/security/tourist-list.jsf"))
              .addRule(Join.path("/contract-list").to("/pages/security/contract-list.jsf"))
              ;
      //ej pasando parametros
      //.addRule(Join.path("/shop/{category}").to("/faces/viewCategory.xhtml"));
   }

   @Override
   public int priority() {
      return 0;
   }
}
