package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Model {

   private long modelCod;
   private String modelName;
   private Mark mark;

   public Model() {
   }

   public Model(long modelCod, String modelName, Mark mark) {
      this.modelCod = modelCod;
      this.modelName = modelName;
      this.mark = mark;
   }

   public long getModelCod() {
      return modelCod;
   }

   public void setModelCod(long modelCod) {
      this.modelCod = modelCod;
   }

   public String getModelName() {
      return modelName;
   }

   public void setModelName(String modelName) {
      this.modelName = modelName;
   }

   public Mark getMark() {
      return mark;
   }

   public void setMark(Mark mark) {
      this.mark = mark;
   }
}
