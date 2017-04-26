package application.dao.DAOimplementation;

import application.components.Instrument;
import application.components.Order;
import application.dao.InstrumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
@Repository
public class InstrumentDAOImpl implements InstrumentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(InstrumentDAOImpl.class.getSimpleName());
    private static final String GET_ALL = "SELECT * FROM instruments";

    private static  final String QUERY_SECOND = "SELECT * FROM instruments WHERE id NOT IN (SELECT o.instrument_id FROM orders o WHERE o.order_time > '2015-03-03' AND o.shipped=FALSE AND o.comment NOTNULL ";
private static final  String INSTRUMENT_AMOUNT = "SELECT category,model,trademark, count(DISTINCT id)AS amount  FROM instruments WHERE instruments.id=(SELECT instrument_id FROM orders WHERE (price > 100)) GROUP BY model,category,trademark";
    private static final String  GET = "SELECT  * FROM instruments WHERE id=?";
    private static final String INSERT = "INSERT INTO instruments (model,category,trademark,company_index,purchase_date,sell_date,functioning,department,price,description) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE instruments SET model=?,category=?,trademark=?,company_index=?,purchase_date=?,sell_date=?,functioning=?,department,price,description WHERE  id=?";
    private static final String DELETE = "DELETE FROM instruments WHERE id=?";
    private static final String GET_ALL_INSTRUMENTS_IN_ORDER = "SELECT * FROM instruments where id=(SELECT instrument_id FROM order_instruments WHERE order_id=?  ";

public List<Instrument> getAllInstrumentsInOrder(Order order){
  return      jdbcTemplate.query(GET_ALL_INSTRUMENTS_IN_ORDER,mapper,order.getId());

}

    public Instrument get(int id) {
        logger.info("Instrument is  retrieved");
        return jdbcTemplate.queryForObject(GET,mapper,id);
    }

    public int insert(Instrument instrument) {
        logger.info("Instrument inserted");
        return jdbcTemplate.update(INSERT,
                instrument.getModel(),
                instrument.getCategory(),
                instrument.getTrademark(),
                instrument.getCompany_index(),
                instrument.getPurchase_date(),
                instrument.getSell_date(),
                instrument.isFunctioning(),
                instrument.getDepartment_id(),
                 instrument.getPrice(),
        instrument.getDescription());
    }

    public void update(Instrument instrument) {
        logger.info("Instrument updated");
        jdbcTemplate.update(UPDATE,
                instrument.getModel(),
                instrument.getCategory(),
                instrument.getTrademark(),
                instrument.getCompany_index(),
                instrument.getPurchase_date(),
                instrument.getSell_date(),
                instrument.isFunctioning(),
                instrument.getDepartment_id(),
        instrument.getPrice(),
        instrument.getDescription());


    }

    public void delete(Instrument instrument) {
        logger.info("Instrument removed");
        jdbcTemplate.update(DELETE,instrument.getId());

    }

    public List<Instrument> getAll() {
        logger.info("Alle instruments are returned");
       return  jdbcTemplate.query(GET_ALL,mapper);
    }

    private RowMapper<Instrument> mapper = new RowMapper<Instrument>(){

        public Instrument mapRow(ResultSet resultSet, int i) throws SQLException {
           Instrument instrument = new Instrument();
           instrument.setId(resultSet.getInt("id"));
           instrument.setModel(resultSet.getString("model"));
           instrument.setCategory(resultSet.getString("category"));
           instrument.setTrademark(resultSet.getString("trademark"));
           instrument.setCompany_index(resultSet.getInt("company_index"));
           instrument.setPurchase_date(resultSet.getString("purchase_date"));
           instrument.setSell_date(resultSet.getString("sell_date"));
           instrument.setFunctioning(resultSet.getBoolean("functioning"));
           instrument.setDepartment_id(resultSet.getInt("department"));

           instrument.setPrice(resultSet.getDouble("price"));
           instrument.setDescription(resultSet.getString("description"));





           return instrument;


        }
    };
}
