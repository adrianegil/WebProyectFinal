package cu.cujae.pweb.jsf2SpringBoot;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
public class Jsf2SpringBootApplication {

   public static void main(String[] args) {
      SpringApplication.run(Jsf2SpringBootApplication.class, args);
   }

   @Bean
   public FilterRegistrationBean rewriteFilter() {
      FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
      rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
              DispatcherType.ASYNC, DispatcherType.ERROR));
      rwFilter.addUrlPatterns("/*");
      return rwFilter;
   }

   @Bean
   public ServletRegistrationBean facesServletRegistration() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
              new FacesServlet(), "*.jsf");
      registration.setLoadOnStartup(1);
      return registration;
   }

   @Bean
   public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
      return new ServletListenerRegistrationBean<ConfigureListener>(
              new ConfigureListener());
   }

   @Bean
   public ServletContextInitializer servletContextInitializer() {

      return sc -> {
         //sc.setInitParameter("com.sun.faces.expressionFactory", "com.sun.el.ExpressionFactoryImpl");
         sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
         sc.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString());
         //sc.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
         sc.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/taglib/primefaces-modena.taglib.xml");
         sc.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
         sc.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
         sc.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString());
         sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
         sc.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
         sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
         sc.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
         sc.setInitParameter("primefaces.THEME", "modena");
      };
   }
}
