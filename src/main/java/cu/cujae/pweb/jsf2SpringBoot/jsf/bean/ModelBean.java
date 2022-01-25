package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;

import cu.cujae.pweb.jsf2SpringBoot.domain.Model;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "request")
@Component(value = "modelBean")
@ELBeanName(value = "modelBean")
public class ModelBean {

   @Autowired
   private RestService restService;

   private List<Model> modelList;
   private Model model;

   public ModelBean() {
      modelList = new ArrayList<>();
   }

   public List<Model> getModelList() throws IOException {
      ApiRestMapper<Model> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/model-list/", null, String.class).getBody();
      return apiRestMapper.mapList(response, Model.class);
   }

   public void setModelList(List<Model> modelList) {
      this.modelList = modelList;
   }

   public Model getModel() {
      return model;
   }

   public void setModel(Model model) {
      this.model = model;
   }
}
