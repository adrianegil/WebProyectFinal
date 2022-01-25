package cu.cujae.pweb.jsf2SpringBoot.domain;

public class Role {

   private Long id;
   private String roleName;

   public Role(Long id, String roleName) {
      this.id = id;
      this.roleName = roleName;
   }

   public Role() {
      super();
      // TODO Auto-generated constructor stub
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }
}
