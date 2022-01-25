package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Mark {

   private long markCod;
   private String markName;

   public Mark() {
   }

   public Mark(long markCod, String markName) {
      this.markCod = markCod;
      this.markName = markName;
   }

   public long getMarkCod() {
      return markCod;
   }

   public void setMarkCod(long markCod) {
      this.markCod = markCod;
   }

   public String getMarkName() {
      return markName;
   }

   public void setMarkName(String markName) {
      this.markName = markName;
   }
}
