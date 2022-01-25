package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMarkRepository implements MarkRepository {


   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;


   @Override
   public Mark findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM marca where codmarca = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Mark(
                              rs.getLong("codmarca"),
                              rs.getString("nombmarca")
                      )
      );
   }

   @Override
   public List<Mark> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM marca",
              (rs, rowNum) ->
                      new Mark(
                              rs.getLong("codmarca"),
                              rs.getString("nombmarca")
                      )
      );
   }
}
