package cu.cujae.pweb.jsf2SpringBoot.repository;

import cu.cujae.pweb.jsf2SpringBoot.domain.Model;
import cu.cujae.pweb.jsf2SpringBoot.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcModelRepository implements ModelRepository {


   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Autowired
   private MarkService markService;

   @Override
   public Model findByCod(Long cod) {
      return namedParameterJdbcTemplate.queryForObject(
              "SELECT * FROM modelo where codmodelo = :cod",
              new MapSqlParameterSource("cod", cod),
              (rs, rowNum) ->
                      new Model(
                              rs.getLong("codmodelo"),
                              rs.getString("nombmodelo"),
                              markService.findByCod(rs.getLong("codmarca"))
                      )
      );
   }

   @Override
   public List<Model> findAllbyMarkCod(long cod) {
      return jdbcTemplate.query(
              "SELECT * FROM modelo WHERE codmarca = ?",
              new Object[]{cod},
              (rs, rowNum) ->
                      new Model(
                              rs.getLong("codmodelo"),
                              rs.getString("nombmodelo"),
                              markService.findByCod(rs.getLong("codmarca"))
                      )
      );
   }

   @Override
   public List<Model> findAll() {
      return namedParameterJdbcTemplate.query(
              "SELECT * FROM modelo ",
              (rs, rowNum) ->
                      new Model(
                              rs.getLong("codmodelo"),
                              rs.getString("nombmodelo"),
                              markService.findByCod(rs.getLong("codmarca"))
                      )
      );
   }
}
