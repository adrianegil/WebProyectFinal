package cu.cujae.pweb.jsf2SpringBoot.util;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("utils.EntityConverter")
public class EntityConverter implements Converter {

   private static final String key = "utils.EntityConverter";

   private Map<String, Object> getViewMap(FacesContext context) {
      Map<String, Object> viewMap = context.getViewRoot().getViewMap();
      @SuppressWarnings({"unchecked", "rawtypes"})
      Map<String, Object> idMap = (Map) viewMap.get(key);
      if (idMap == null) {
         idMap = new HashMap<String, Object>();
         viewMap.put(key, idMap);
      }
      return idMap;
   }

   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      if (context == null || component == null) {
         throw new NullPointerException();
      }
      return getViewMap(context).get(value);
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      if (context == null || component == null) {
         throw new NullPointerException();
      }
      if (value != null) {
         String id = value.toString();
         getViewMap(context).put(id, value.getClass().cast(value));
         return id;
      }
      return "";
   }
}
