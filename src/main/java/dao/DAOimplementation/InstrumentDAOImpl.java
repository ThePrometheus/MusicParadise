package dao.DAOimplementation;

import components.Instrument;
import dao.InstrumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nazar on 11.04.17.
 */
public class InstrumentDAOImpl implements InstrumentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(InstrumentDAOImpl.class.getSimpleName());

    private static final String  GET = "SELECT  * FROM instruments WHERE id=?";
    private static final String INSERT = "INSERT INTO instruments (model,category,trademark,company_index,purchase_date,sell_date,functioning,instruments_department_id) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE instruments SET model=?,category=?,trademark=?,company_index=?,purchase_date=?,sell_date=?,functioning=?,instruments_department_id WHERE id=?";
    private static final String DELETE = "DELETE FROM instruments WHERE id=?";



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
                instrument.getCategory(),
                instrument.getPurchase_date(),
                instrument.getSell_date(),
                instrument.isFunctioning(),
                instrument.getDepartment_id());
    }

    public void update(Instrument instrument) {
        logger.info("Instrument updated");
        jdbcTemplate.update(UPDATE,
                instrument.getModel(),
                instrument.getCategory(),
                instrument.getTrademark(),
                instrument.getCategory(),
                instrument.getPurchase_date(),
                instrument.getSell_date(),
                instrument.isFunctioning(),
                instrument.getDepartment_id());


    }

    public void delete(Instrument instrument) {
        logger.info("Instrument removed");
        jdbcTemplate.update(DELETE,instrument.getId());

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
           instrument.setDepartment_id(resultSet.getInt("department_id"));




           return instrument;


        }
    };
}
