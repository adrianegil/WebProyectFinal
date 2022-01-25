package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Car {

   private long carCod;
   private String badgeNumb;
   private int cantkm;
   private String color;
   private Rate rate;
   private Model model;
   private Situation situation;

   @Override
   public String toString() {
      return badgeNumb + " " + model.getMark().getMarkName() + " " + model.getModelName();
   }

   public Car() {
   }

   public Car(long carCod, String badgeNumb, int cantkm, String color, Rate rate, Model model, Situation situation) {
      this.carCod = carCod;
      this.badgeNumb = badgeNumb;
      this.cantkm = cantkm;
      this.color = color;
      this.rate = rate;
      this.model = model;
      this.situation = situation;
   }

   public long getCarCod() {
      return carCod;
   }

   public void setCarCod(long carCod) {
      this.carCod = carCod;
   }

   public String getBadgeNumb() {
      return badgeNumb;
   }

   public void setBadgeNumb(String badgeNumb) {
      this.badgeNumb = badgeNumb;
   }

   public int getCantkm() {
      return cantkm;
   }

   public void setCantkm(int cantkm) {
      this.cantkm = cantkm;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public Rate getRate() {
      return rate;
   }

   public void setRate(Rate rate) {
      this.rate = rate;
   }

   public Model getModel() {
      return model;
   }

   public void setModel(Model model) {
      this.model = model;
   }

   public Situation getSituation() {
      return situation;
   }

   public void setSituation(Situation situation) {
      this.situation = situation;
   }
}
