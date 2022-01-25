package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRateRepository implements RateRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;


   @Override
   public Rate findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM tarifa where codtarifa = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Rate(
                              rs.getLong("codtarifa"),
                              rs.getDouble("ingreso"),
                              rs.getDouble("ingresoespecial")
                      )
      );
   }

   @Override
   public int save(Rate rate) {

      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

      mapSqlParameterSource.addValue("ingreso", rate.getCost());
      mapSqlParameterSource.addValue("ingresoespecial", rate.getSpecialCost());

      return namedParameterJdbcTemplate.update(
              "INSERT INTO tarifa (ingreso, ingresoespecial) " +
                      "VALUES (:ingreso, :ingresoespecial)",
              mapSqlParameterSource);
   }

   @Override
   public Rate findByRate(double cost, double specialcost) {

     /*   MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ingreso", cost);
        mapSqlParameterSource.addValue("ingresoespecial", specialcost);

            return namedParameterJdbcTemplate.queryForObject(
                    "SELECT * FROM tarifa WHERE ingreso = :ingreso AND ingresoespecial = :ingresoespecial",
                    mapSqlParameterSource,
                    (rs, rowNum) ->
                            new Rate(
                                    rs.getLong("codtarifa"),
                                    rs.getDouble("ingreso"),
                                    rs.getDouble("ingresoespecial")
                            )
            );*/
      /*  return jdbcTemplate.queryForObject(
                "SELECT * FROM tarifa order by id desc limit 1",
                new Object[]{cost,specialcost},
                (rs, rowNum) ->
                        new Rate(
                                rs.getLong("codtarifa"),
                                rs.getDouble("ingreso"),
                                rs.getDouble("ingresoespecial")
                        )
        );*/
      return jdbcTemplate.queryForObject(
              "SELECT * FROM tarifa WHERE ingreso =? AND ingresoespecial = ? limit 1",
              new Object[]{cost, specialcost},
              (rs, rowNum) ->
                      new Rate(
                              rs.getLong("codtarifa"),
                              rs.getDouble("ingreso"),
                              rs.getDouble("ingresoespecial")
                      )
      );
   }
}
