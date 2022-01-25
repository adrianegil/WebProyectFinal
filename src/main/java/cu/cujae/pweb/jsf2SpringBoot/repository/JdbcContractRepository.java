package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Contract;
import cu.cujae.pweb.jsf2SpringBoot.service.CarService;
import cu.cujae.pweb.jsf2SpringBoot.service.DriverService;
import cu.cujae.pweb.jsf2SpringBoot.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcContractRepository implements ContractRepository {


   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Autowired
   private CarService carService;

   @Autowired
   private TouristService touristService;

   @Autowired
   private DriverService driverService;

   @Override
   public int count() {
      return jdbcTemplate
              .queryForObject("SELECT count(*) FROM contrato", Integer.class);
   }

   @Override
   public List<Contract> findAll() {

      return namedParameterJdbcTemplate.query(
              "SELECT * FROM contrato",
              (rs, rowNum) ->
                      new Contract(

                              carService.findByCod(rs.getLong("codauto")),
                              touristService.findByCod(rs.getLong("codturis")),
                              rs.getLong("codcontr"),
                              rs.getDate("fechinicio"),
                              rs.getDate("fechfin"),
                              rs.getInt("cantdiasporr"),
                              rs.getString("formpago"),
                              driverService.findByCod(rs.getLong("codchof")),
                              rs.getDate("fechentrega_auto"),
                              rs.getDouble("importetotal"),
                              rs.getString("nombcontratista")
                      )
      );
   }

   @Override
   public int deleteByCod(Long cod) {
      return jdbcTemplate.update(
              "DELETE FROM contrato WHERE codcontr = ?",
              cod);
   }

   @Override
   public int save(Contract contract) {

      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("codauto", contract.getCar().getCarCod());
      mapSqlParameterSource.addValue("codturis", contract.getTourist().getTouristCod());
      mapSqlParameterSource.addValue("fechinicio", contract.getBeginDate());
      mapSqlParameterSource.addValue("fechfin", contract.getEndDate());
      mapSqlParameterSource.addValue("formpago", contract.getPaymentWay());
      try {
         mapSqlParameterSource.addValue("codchof", contract.getDriver().getDrivCod());

      } catch (Exception e) {
         mapSqlParameterSource.addValue("codchof", null);

      }
      mapSqlParameterSource.addValue("nombcontratista", contract.getContractorName());

      return namedParameterJdbcTemplate.update(
              "INSERT INTO contrato (codauto, codturis, fechinicio, fechfin,formpago, codchof,nombcontratista) " +
                      "VALUES (:codauto, :codturis, :fechinicio, :fechfin,:formpago, :codchof, :nombcontratista )",
              mapSqlParameterSource);
   }

   @Override
   public int update(Contract contract) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("codcontr", contract.getContractCod());
      mapSqlParameterSource.addValue("fechentrega_auto", contract.getDeliveryDateCar());

      return namedParameterJdbcTemplate.update(
              "UPDATE contrato SET fechentrega_auto = :fechentrega_auto WHERE codcontr = :codcontr",
              mapSqlParameterSource);
   }
}
