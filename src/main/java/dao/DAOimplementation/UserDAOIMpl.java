package dao.DAOimplementation;

import components.Order;
import components.User;
import dao.UserDAO;
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
public class UserDAOIMpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(UserDAOIMpl.class.getSimpleName());
    private static final String  GET = "SELECT  * FROM users WHERE id=?";
    private static final String INSERT = "INSERT INTO users(login,password,role) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE users  SET login=?,password=?,role=? WHERE id=?";
    private static final String DELETE = "DELETE FROM users WHERE id=?";


    public User get(int id) {
        return null;
    }

    public int insert(User user) {
        return 0;
    }

    public void delete(User user) {

    }

    public void update(User user) {

    }

    private RowMapper<User> mapper = new RowMapper<User>() {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));


            return user;
        }
    };

}
