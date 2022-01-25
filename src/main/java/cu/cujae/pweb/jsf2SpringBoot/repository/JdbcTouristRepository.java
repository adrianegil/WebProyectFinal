package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Tourist;
import cu.cujae.pweb.jsf2SpringBoot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcTouristRepository implements TouristRepository {

   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Autowired
   private CountryService countryService;

   @Override
   public int count() {
      return jdbcTemplate
              .queryForObject("SELECT count(*) FROM turista", Integer.class);
   }

   @Override
   public List<Tourist> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM turista",
              (rs, rowNum) ->
                      new Tourist(
                              rs.getLong("codturis"),
                              rs.getLong("numpaspturis"),
                              rs.getString("nomturis"),
                              rs.getString("apellturis"),
                              rs.getString("sexturis"),
                              rs.getInt("edadturist"),
                              rs.getLong("contactturist"),
                              countryService.findByCod(rs.getLong("pais__codpais")),
                              rs.getString("email")
                      )
      );
   }

   @Override
   public int deleteByCod(Long cod) {
      return jdbcTemplate.update(
              "DELETE FROM turista WHERE codturis = ?",
              cod);
   }

   @Override
   public Tourist findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM turista where codturis = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Tourist(
                              rs.getLong("codturis"),
                              rs.getLong("numpaspturis"),
                              rs.getString("nomturis"),
                              rs.getString("apellturis"),
                              rs.getString("sexturis"),
                              rs.getInt("edadturist"),
                              rs.getLong("contactturist"),
                              countryService.findByCod(rs.getLong("pais__codpais")),
                              rs.getString("email")
                      )
      );
   }

   @Override
   public int save(Tourist tourist) {
      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("numpaspturis", tourist.getPassportNumb());
      mapSqlParameterSource.addValue("nomturis", tourist.getTouristName());
      mapSqlParameterSource.addValue("apellturis", tourist.getTouristLastName());
      mapSqlParameterSource.addValue("sexturis", tourist.getTouristSex());
      mapSqlParameterSource.addValue("edadturist", tourist.getTouristAge());
      mapSqlParameterSource.addValue("contactturist", tourist.getTouristContact());
      mapSqlParameterSource.addValue("pais__codpais", tourist.getTouristCountry().getCountyCod());
      mapSqlParameterSource.addValue("email", tourist.getEmail());

      return namedParameterJdbcTemplate.update(
              "INSERT INTO turista (numpaspturis, nomturis, apellturis, sexturis, edadturist, contactturist, pais__codpais, email) " +
                      "VALUES (:numpaspturis, :nomturis, :apellturis, :sexturis,:edadturist,:contactturist,:pais__codpais, :email)",
              mapSqlParameterSource);
   }

   @Override
   public int update(Tourist tourist) {

      MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
      mapSqlParameterSource.addValue("codturis", tourist.getTouristCod());
      mapSqlParameterSource.addValue("numpaspturis", tourist.getPassportNumb());
      mapSqlParameterSource.addValue("nomturis", tourist.getTouristName());
      mapSqlParameterSource.addValue("apellturis", tourist.getTouristLastName());
      mapSqlParameterSource.addValue("sexturis", tourist.getTouristSex());
      mapSqlParameterSource.addValue("edadturist", tourist.getTouristAge());
      mapSqlParameterSource.addValue("contactturist", tourist.getTouristContact());
      mapSqlParameterSource.addValue("pais__codpais", tourist.getTouristCountry().getCountyCod());
      mapSqlParameterSource.addValue("email", tourist.getEmail());

      return namedParameterJdbcTemplate.update(
              "UPDATE turista SET numpaspturis = :numpaspturis, nomturis = :nomturis, apellturis = :apellturis, sexturis = :sexturis, " +
                      "edadturist = :edadturist, contactturist = :contactturist, pais__codpais = :pais__codpais," +
                      " email = :email WHERE codturis = :codturis",
              mapSqlParameterSource);
   }
}
