package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcDriverRepository implements DriverRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public int count() {
      return jdbcTemplate
              .queryForObject("SELECT count(*) FROM chofer", Integer.class);
   }

   @Override
   public List<Driver> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM chofer",
              (rs, rowNum) ->
                      new Driver(
                              rs.getLong("codchof"),
                              rs.getString("idchof"),
                              rs.getString("nombchof"),
                              rs.getString("apellchof"),
                              rs.getString("dirchof"),
                              rs.getString("catchof"),
                              rs.getBoolean("disponible"),
                              rs.getString("email")
                      )
      );
   }

   @Override
   public List<Driver> findAllAvailable() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM chofer WHERE disponible=TRUE ",
              (rs, rowNum) ->
                      new Driver(
                              rs.getLong("codchof"),
                              rs.getString("idchof"),
                              rs.getString("nombchof"),
                              rs.getString("apellchof"),
                              rs.getString("dirchof"),
                              rs.getString("catchof"),
                              rs.getBoolean("disponible"),
                              rs.getString("email")
                      )
      );
   }

   @Override
   public int deleteByCod(Long cod) {
      return jdbcTemplate.update(
              "DELETE FROM chofer WHERE codchof = ?",
              cod);
   }

   @Override
   public Driver findByCod(Long cod) {

      if (cod != 0) {
         return namedParameterJdbcTemplate.queryForObject(
                 "SELECT * FROM chofer where codchof = :cod",
                 new MapSqlParameterSource("cod", cod),
                 (rs, rowNum) ->
                         new Driver(
                                 rs.getLong("codchof"),
                                 rs.getString("idchof"),
                                 rs.getString("nombchof"),
                                 rs.getString("apellchof"),
                                 rs.getString("dirchof"),
                                 rs.getString("catchof"),
                                 rs.getBoolean("disponible"),
                                 rs.getString("email")
                         )
         );
      } else {
         return null;
      }
   }

   @Override
   public Optional<Driver> findById(Long id) {

      if (id != 0) {
         return namedParameterJdbcTemplate.queryForObject(
                 "SELECT * FROM chofer where codchof = :id",
                 new MapSqlParameterSource("id", id),
                 (rs, rowNum) ->
                         Optional.of(new Driver(
                                 rs.getLong("codchof"),
                                 rs.getString("idchof"),
                                 rs.getString("nombchof"),
                                 rs.getString("apellchof"),
                                 rs.getString("dirchof"),
                                 rs.getString("catchof"),
                                 rs.getBoolean("disponible"),
                                 rs.getString("email")
                         ))
         );
      } else {
         // Optional<Driver> optionalDriver = new Optional<Driver>();
         return null;
      }
   }

   @Override
   public int save(Driver driver) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("idchof", driver.getDrivId());
      mapSqlParameterSource.addValue("nombchof", driver.getDrivName());
      mapSqlParameterSource.addValue("apellchof", driver.getDrivLastName());
      mapSqlParameterSource.addValue("dirchof", driver.getDrivAddress());
      mapSqlParameterSource.addValue("catchof", driver.getDrivCat());
      mapSqlParameterSource.addValue("email", driver.getEmail());

      return namedParameterJdbcTemplate.update(
              "INSERT INTO chofer (idchof, nombchof, apellchof, dirchof,catchof,email) " +
                      "VALUES (:idchof, :nombchof, :apellchof, :dirchof,:catchof,:email)",
              mapSqlParameterSource);
   }

   @Override
   public int update(Driver driver) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("codchof", driver.getDrivCod());
      mapSqlParameterSource.addValue("idchof", driver.getDrivId());
      mapSqlParameterSource.addValue("nombchof", driver.getDrivName());
      mapSqlParameterSource.addValue("apellchof", driver.getDrivLastName());
      mapSqlParameterSource.addValue("dirchof", driver.getDrivAddress());
      mapSqlParameterSource.addValue("catchof", driver.getDrivCat());
      mapSqlParameterSource.addValue("email", driver.getEmail());

      return namedParameterJdbcTemplate.update(
              "UPDATE chofer SET idchof = :idchof, nombchof = :nombchof, apellchof = :apellchof, " +
                      "dirchof = :dirchof, catchof = :catchof, email = :email WHERE codchof = :codchof",
              mapSqlParameterSource);
   }
}
