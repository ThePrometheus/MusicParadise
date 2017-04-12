package dao.DAOimplementation;

import components.Client;
import components.Consultant;
import components.Order;
import dao.OrderDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pojo.ClientOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class.getSimpleName());
    private static final String GET = "SELECT  * FROM orders WHERE id=?";
    private static final String INSERT = "INSERT INTO orders (consultant,client,shipped,order_time,ship_time,comment,price) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE orders  SET onsultant=?,client=?,shipped=?,order_time=?,ship_time=?,comment=?,price=? WHERE id=?";
    private static final String DELETE = "DELETE FROM orders WHERE id=?";
    private static final String GET_ALL_ORDERS_FOR_CLIENT = "SELECT * FROM orders WHERE client=? ORDER BY order_time DESC";
    private static final String GET_ALL_ORDERS_FOR_CONSULTANT = "SELECT * FROM orders WHERE consultant=? ORDER BY order_time DESC";
    private static final String GET_CLIENT_ORDER_BY_ID = "SELECT * FROM \"orders\" o INNER JOIN client c ON client.login=c.login WHERE o.id=?";

    public List<Order> getAllOrdersForConsultant(Consultant consultant) {
        return jdbcTemplate.query(GET_ALL_ORDERS_FOR_CONSULTANT, mapper, consultant.getId());
    }

    private static final String EXECUTED_ORDER = "UPDATE orders SET shipped_time=now() WHERE id=?";


    public void executedOrder(Order order) {

    }


    public Order get(int id) {
        logger.info("Order is  retrieved");
        return jdbcTemplate.queryForObject(GET, mapper, id);
    }

    public int insert(Order order) {
        logger.info("Order inserted");
        return jdbcTemplate.update(INSERT,
                order.isShipped(),
                order.getOrder_time(),
                order.getShip_time(),
                order.getComment(),
                order.getConsultant_id(),
                order.getClient_id(),
                order.getPrice()
        );
    }

    public void delete(Order order) {
        logger.info("Order is removed");
        jdbcTemplate.update(DELETE, order.getId());


    }

    public void update(Order order) {
        logger.info("Order updated");
        jdbcTemplate.update(UPDATE,
                order.isShipped(),
                order.getOrder_time(),
                order.getShip_time(),
                order.getComment(),
                order.getConsultant_id(),
                order.getClient_id(),
                order.getPrice()
        );

    }

    public List<Order> getAllForClient(Client client) {
        return jdbcTemplate.query(GET_ALL_ORDERS_FOR_CLIENT, mapper, client.getId());
    }

    public void executeOrder(Order order) {
        jdbcTemplate.query(EXECUTED_ORDER, mapper, order.getId());

    }

    public ClientOrder getClientOrderById(int id) {
        List<ClientOrder> resp = jdbcTemplate.query(GET_CLIENT_ORDER_BY_ID, clientOrderMapper, id);
        return (resp.isEmpty()) ? null : resp.get(0);
    }


    private RowMapper<Order> mapper = new RowMapper<Order>() {

        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setOrder_time(resultSet.getString("order_time"));
            order.setShipped(resultSet.getBoolean("shipped"));
            order.setShip_time(resultSet.getString("ship_time"));
            order.setComment(resultSet.getString("comment"));
            order.setConsultant_id(resultSet.getInt("consultant"));
            order.setClient_id(resultSet.getInt("client"));
            order.setPrice(resultSet.getDouble("price"));


            return order;


        }
    };
    private RowMapper<ClientOrder> clientOrderMapper = new RowMapper<ClientOrder>() {

        public ClientOrder mapRow(ResultSet resultSet, int i) throws SQLException {

            Client client = new Client();
            // client.setId(resultSet.getInt("id"));
            client.setLogin(resultSet.getString("login"));
            client.setSurname(resultSet.getString("surname"));
            client.setFirstname(resultSet.getString("firstname"));
            client.setMiddlename(resultSet.getString("middlename"));

            client.setAddress(resultSet.getString("address"));
            client.setEmail(resultSet.getString("email"));
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setOrder_time(resultSet.getString("order_time"));
            order.setShipped(resultSet.getBoolean("shipped"));
            order.setShip_time(resultSet.getString("ship_time"));
            order.setComment(resultSet.getString("comment"));
            order.setConsultant_id(resultSet.getInt("consultant"));
            order.setClient_id(resultSet.getInt("client"));
            order.setPrice(resultSet.getDouble("price"));
            return new ClientOrder(client, order);


        }
    };
}
