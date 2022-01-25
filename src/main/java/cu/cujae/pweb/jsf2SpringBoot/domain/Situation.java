package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Situation {

   private long situationCod;
   private String situationName;

   public Situation() {
   }

   public Situation(long situationCod, String situationName) {
      this.situationCod = situationCod;
      this.situationName = situationName;
   }

   public long getSituationCod() {
      return situationCod;
   }

   public void setSituationCod(long situationCod) {
      this.situationCod = situationCod;
   }

   public String getSituationName() {
      return situationName;
   }

   public void setSituationName(String situationName) {
      this.situationName = situationName;
   }
}
