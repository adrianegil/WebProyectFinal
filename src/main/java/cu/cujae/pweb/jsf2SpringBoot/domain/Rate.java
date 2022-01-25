package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Rate {

   private long rateCod;
   private double cost;
   private double specialCost;

   public Rate() {
   }

   public Rate(long rateCod, double cost, double specialCost) {
      this.rateCod = rateCod;
      this.cost = cost;
      this.specialCost = specialCost;
   }

   public long getRateCod() {
      return rateCod;
   }

   public void setRateCod(long rateCod) {
      this.rateCod = rateCod;
   }

   public double getCost() {
      return cost;
   }

   public void setCost(double cost) {
      this.cost = cost;
   }

   public double getSpecialCost() {
      return specialCost;
   }

   public void setSpecialCost(double specialCost) {
      this.specialCost = specialCost;
   }
}
