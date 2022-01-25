package cu.cujae.pweb.jsf2SpringBoot.config;

import freemarker.template.Template;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.io.IOException;

@Configuration
public class FreemarkerConfig {

   @Bean
   public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
      FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
      bean.setTemplateLoaderPath("/templates/");
      return bean;
   }

   public Template getTemplate(String name) throws IOException {
      Template t = new Template(name, "", null);
      return t;
   }
}
