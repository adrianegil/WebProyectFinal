package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Situation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSituationRepository implements SituationRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public Situation findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM situacion where codsituac = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Situation(
                              rs.getLong("codsituac"),
                              rs.getString("nombsituac")
                      )
      );
   }
}
