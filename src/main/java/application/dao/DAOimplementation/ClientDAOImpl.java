package application.dao.DAOimplementation;

import application.components.Client;
import application.dao.ClientDAO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.slf4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by nazar on 11.04.17.
 */
@Repository
public class ClientDAOImpl implements ClientDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String GET = "SELECT  * FROM clients WHERE login=?";
    private static final String INSERT = "INSERT INTO clients (login,surname,firstname,middlename,tel_number,address,email) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE clients SET  surname=?,firstname=?,middlename=?,tel_number=?,address=?,email=? WHERE login=?";
    private static final String DELETE = "DELETE FROM clients WHERE login=?";

    private static Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class.getSimpleName());

    public Client get(String login ) {
        logger.info("Client retrieved");
        return jdbcTemplate.queryForObject(GET,mapper,login );
    }

    public int insert(Client client) {
            logger.info("Client inserted");
           return jdbcTemplate.update(INSERT,
                   client.getLogin(),
                   client.getSurname(),
                   client.getFirstname(),
                   client.getMiddlename(),

                   client.getTel_number(),
                   client.getAddress(),
                   client.getEmail());
    }

    public void update(Client client) {
        logger.info("Client updated");
         jdbcTemplate.update(UPDATE,
                client.getSurname(),
                client.getFirstname(),
                client.getMiddlename(),

                client.getTel_number(),
                client.getAddress(),
                client.getEmail());

    }

    public void delete(Client client) {
        logger.info("Client is  deleted");
        jdbcTemplate.update(DELETE, client.getLogin());

    }


    private RowMapper<Client> mapper = new RowMapper<Client>() {
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            Client client = new Client();
          //  client.setId(resultSet.getInt("id"));
            client.setLogin(resultSet.getString("login"));
            client.setSurname(resultSet.getString("surname"));
            client.setFirstname(resultSet.getString("firstname"));
            client.setMiddlename(resultSet.getString("middlename"));

            client.setAddress(resultSet.getString("address"));
            client.setEmail(resultSet.getString("email"));
            return client;


        }






    };
}

