package application.dao.DAOimplementation;

import application.components.Consultant;
import application.components.Instrument;
import application.components.Order;
import application.dao.OrderInstrumentDAO;
import application.pojo.OrderInstrument;
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
 * Created by nazar on 12.04.17.
 */
@Repository
public class  OrderInstrumentDAOImpl implements OrderInstrumentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(OrderInstrumentDAOImpl.class.getSimpleName());
    private static final String GET_ALL_FOR_CONSULTANT= "SELECT * FROM order_instruments WHERE consultant=?";
    private static  final String CREATE="INSERT INTO order_instruments(order_id,instrument_id,consultant_login,enabled) VALUES(?,?,?,FALSE)";
    private static final  String REMOVE="DELETE * FROM order_instruments WHERE order_id=? AND  instrument_id=?";
        private  static  final String GET_WAITING_BY_DEPARTMENT = "SELECT * FROM order_instruments oi INNER JOIN instruments i ON  oi.instrument_id = i.id WHERE  i.department=? AND oi.enabled=FALSE";
    private static final String GET_BY_INSTRUMENT_ID= "SELECT * FROM order_instruments WHERE instrument_id?";
    private static     final String GET_BY_ORDER_ID= "SELECT * FROM order_instrument WHERE order_id=?";
    private  static  final  String GET_WAITING_FOR_ACCEPT= "SELECT * FROM order_instruments WHERE enabled=FALSE";
    private static final String ENABLE =  "UPDATE order_instrument SET enabled=FALSE AND consultant=? WHERE order_id=? AND instrument_id=? ";

    public int createOrderInstrument(Order order, Instrument instrument, Consultant consultant) throws Exception {
      return   jdbcTemplate.update(CREATE,mapper,order.getId(),instrument.getId(),consultant.getLogin());
    }

    public int enable(OrderInstrument orderInstrument, Consultant consultant){
        return jdbcTemplate.update(ENABLE,mapper,consultant.getLogin(),orderInstrument.getOrder().getId(),orderInstrument.getInstrument().getId());
    }
    public int decline(OrderInstrument orderInstrument,Consultant consultant){
        return jdbcTemplate.update(ENABLE,mapper,consultant.getLogin(),orderInstrument.getOrder().getId(),orderInstrument.getInstrument().getId());
    }


    public int removeOrderInstrument(Order order, Instrument instrument, Consultant consultant) throws Exception {
        return jdbcTemplate.update(REMOVE,order.getId(),instrument.getId());
    }

    public List<OrderInstrument> getWaitingForAccept(Consultant consultant) {
        return jdbcTemplate.query(GET_WAITING_BY_DEPARTMENT, mapper, consultant.getDepartment_id());
    }

    public OrderInstrument getByInstrumentId(int id) {
        return jdbcTemplate.queryForObject(GET_BY_INSTRUMENT_ID,mapper,id);

    }

    public List<OrderInstrument> getByOrderId(int id) {
        return jdbcTemplate.query(GET_BY_ORDER_ID,mapper,id);
    }

    public List<OrderInstrument> getByConsultant(Consultant consultant) {
        return jdbcTemplate.query(GET_ALL_FOR_CONSULTANT,mapper,consultant.getLogin());
    }

    private RowMapper<OrderInstrument> mapper = new RowMapper<OrderInstrument>() {

        public OrderInstrument mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setOrder_time(resultSet.getString("order_time"));
            order.setShipped(resultSet.getBoolean("shipped"));
            order.setShip_time(resultSet.getString("ship_time"));
            order.setComment(resultSet.getString("comment"));
            order.setConsultant_id(resultSet.getInt("consultant"));
            order.setClient_id(resultSet.getInt("client"));
            order.setPrice(resultSet.getDouble("price"));
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
            OrderInstrument orderInstrument= new OrderInstrument(order,instrument);
            return orderInstrument;



        }};
    }

