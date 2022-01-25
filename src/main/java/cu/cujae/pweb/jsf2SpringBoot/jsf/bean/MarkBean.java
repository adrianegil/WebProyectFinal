package cu.cujae.pweb.jsf2SpringBoot.jsf.bean;


import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;
import cu.cujae.pweb.jsf2SpringBoot.domain.Model;
import cu.cujae.pweb.jsf2SpringBoot.util.ApiRestMapper;
import cu.cujae.pweb.jsf2SpringBoot.util.RestService;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Scope(value = "request")
@Component(value = "markBean")
@ELBeanName(value = "markBean")
public class MarkBean {


   @Autowired
   private RestService restService;

   private List<Mark> markList;
   private Mark mark;

   public MarkBean() {
      mark = new Mark();
      markList = new ArrayList<>();
   }

   public List<Mark> getMarkList() throws IOException {
      ApiRestMapper<Mark> apiRestMapper = new ApiRestMapper<>();
      String response = (String) restService.GET("/api/v1/mark", null, String.class).getBody();
      return apiRestMapper.mapList(response, Mark.class);
   }

   public void setMarkList(List<Mark> markList) {
      this.markList = markList;
   }

   public Mark getMark() {
      return mark;
   }

   public void setMark(Mark mark) {
      this.mark = mark;
   }
}
