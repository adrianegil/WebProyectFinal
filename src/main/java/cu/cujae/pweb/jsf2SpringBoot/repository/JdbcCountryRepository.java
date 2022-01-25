package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCountryRepository implements CountryRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public Country findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM pais where codpais = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Country(
                              rs.getLong("codpais"),
                              rs.getString("nombpais")
                      )
      );
   }

   @Override
   public List<Country> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM pais ORDER BY nombpais",
              (rs, rowNum) ->
                      new Country(
                              rs.getLong("codpais"),
                              rs.getString("nombpais")
                      )
      );
   }
}
