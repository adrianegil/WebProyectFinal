package cu.cujae.pweb.jsf2SpringBoot.util;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiRestMapper<T> {

   private static Logger log = LoggerFactory.getLogger(ApiRestMapper.class);

   public List<T> mapList(Object response, Class<? extends T> cls)
           throws java.io.IOException {
      ObjectMapper mapper = new ObjectMapper();

      return mapper.readValue(
              String.valueOf(response),
              mapper.getTypeFactory().constructParametricType(List.class, cls)
      );
   }

   public T mapOne(Object response, Class<? extends T> cls) throws IOException {
      ObjectMapper mapper = new ObjectMapper();

      return mapper.readValue(String.valueOf(response), cls);
   }
}
