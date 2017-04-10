package dao.DAOimplementation;

import components.Order;
import dao.OrderDAO;
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
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class.getSimpleName());
    private static final String  GET = "SELECT  * FROM orders WHERE id=?";
    private static final String INSERT = "INSERT INTO orders (shipped,order_date,ship_date,comment,consultant,client) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE orders  SET shipped=?,order_date=?,ship_date=?,comment=?,consultant=?,client=? WHERE id=?";
    private static final String DELETE = "DELETE FROM orders WHERE id=?";


    public Order get(int id) {
        logger.info("Order is  retrieved");
        return jdbcTemplate.queryForObject(GET,mapper,id);
    }
    public int insert(Order order) {
        logger.info("Order inserted");
        return jdbcTemplate.update(INSERT,
                order.isShipped(),
                order.getOrder_date(),
                order.getShip_date(),
                order.getComment(),
                order.getConsultant_id(),
                order.getClient_id()
                );
    }

    public void delete(Order order) {
        logger.info("Order is removed");
        jdbcTemplate.update(DELETE,order.getId());


    }

    public void update(Order order) {
        logger.info("Order updated");
        jdbcTemplate.update(UPDATE,
                order.isShipped(),
                order.getOrder_date(),
                order.getShip_date(),
                order.getComment(),
                order.getConsultant_id(),
                order.getClient_id()
        );

    }
    private RowMapper<Order> mapper = new RowMapper<Order>(){

        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
           Order order = new Order();
           order.setId(resultSet.getInt("id"));
           order.setOrder_date(resultSet.getString("order_date"));
           order.setShipped(resultSet.getBoolean("shipped"));
           order.setShip_date(resultSet.getString("ship_date"));
           order.setComment(resultSet.getString("comment"));
           order.setConsultant_id(resultSet.getInt("consultant"));
           order.setClient_id(resultSet.getInt("client"));




            return order;


        }
    };
}
