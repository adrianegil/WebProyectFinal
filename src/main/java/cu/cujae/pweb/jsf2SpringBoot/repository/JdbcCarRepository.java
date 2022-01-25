package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Car;
import cu.cujae.pweb.jsf2SpringBoot.service.MarkService;
import cu.cujae.pweb.jsf2SpringBoot.service.ModelService;
import cu.cujae.pweb.jsf2SpringBoot.service.RateService;
import cu.cujae.pweb.jsf2SpringBoot.service.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCarRepository implements CarRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Autowired
   private RateService rateService;

   @Autowired
   private ModelService modelService;

   @Autowired
   private MarkService markService;

   @Autowired
   private SituationService situationService;

   @Override
   public int count() {
      return jdbcTemplate
              .queryForObject("SELECT count(*) FROM auto", Integer.class);
   }

   @Override
   public List<Car> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM auto",
              (rs, rowNum) ->
                      new Car(
                              rs.getLong("codauto"),
                              rs.getString("placauto"),
                              rs.getInt("cantkm"),
                              rs.getString("colauto"),
                              rateService.findByCod(rs.getLong("codtarifa")),
                              modelService.findByCod(rs.getLong("codmodelo")),
                              situationService.findByCod(rs.getLong("codsituac"))
                      )
      );
   }

   @Override
   public List<Car> findAllAvailable() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM auto WHERE codsituac = 3",
              (rs, rowNum) ->
                      new Car(
                              rs.getLong("codauto"),
                              rs.getString("placauto"),
                              rs.getInt("cantkm"),
                              rs.getString("colauto"),
                              rateService.findByCod(rs.getLong("codtarifa")),
                              modelService.findByCod(rs.getLong("codmodelo")),
                              situationService.findByCod(rs.getLong("codsituac"))
                      )
      );
   }

   @Override
   public int deleteByCod(Long cod) {
      return jdbcTemplate.update(
              "DELETE FROM auto WHERE codauto = ?",
              cod);
   }

   @Override
   public Car findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM auto where codauto = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Car(
                              rs.getLong("codauto"),
                              rs.getString("placauto"),
                              rs.getInt("cantkm"),
                              rs.getString("colauto"),
                              rateService.findByCod(rs.getLong("codtarifa")),
                              modelService.findByCod(rs.getLong("codmodelo")),
                              situationService.findByCod(rs.getLong("codsituac"))
                      )
      );
   }

   @Override
   public int save(Car car) {

      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("placauto", car.getBadgeNumb());
      mapSqlParameterSource.addValue("cantkm", car.getCantkm());
      mapSqlParameterSource.addValue("colauto", car.getColor());
      mapSqlParameterSource.addValue("codtarifa", car.getRate().getRateCod());
      mapSqlParameterSource.addValue("codmodelo", car.getModel().getModelCod());
      mapSqlParameterSource.addValue("codsituac", 3);

      return namedParameterJdbcTemplate.update(
              "INSERT INTO auto (placauto, cantkm, colauto, codtarifa,codmodelo,codsituac) " +
                      "VALUES (:placauto, :cantkm, :colauto, :codtarifa,:codmodelo,:codsituac)",
              mapSqlParameterSource);
   }

   @Override
   public int update(Car car) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

      mapSqlParameterSource.addValue("codauto", car.getCarCod());
      mapSqlParameterSource.addValue("placauto", car.getBadgeNumb());
      mapSqlParameterSource.addValue("cantkm", car.getCantkm());
      mapSqlParameterSource.addValue("colauto", car.getColor());
      mapSqlParameterSource.addValue("codtarifa", car.getRate().getRateCod());
      mapSqlParameterSource.addValue("codmodelo", car.getModel().getModelCod());
      mapSqlParameterSource.addValue("codsituac", car.getSituation().getSituationCod());

      return namedParameterJdbcTemplate.update(
              "UPDATE auto SET placauto = :placauto, cantkm = :cantkm, colauto = :colauto, " +
                      "codtarifa = :codtarifa, codmodelo = :codmodelo, codsituac = :codsituac  WHERE codauto = :codauto",
              mapSqlParameterSource);
   }
}
/*
 */