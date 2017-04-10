package dao.DAOimplementation;

import components.Department;
import dao.DepartmentDAO;
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
public class DepartmentDAOImpl implements DepartmentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class.getSimpleName());

    private static final String GET = "SELECT  * FROM departments WHERE id=?";
    private static final String INSERT = "INSERT INTO departments (address) VALUES (?)";
    private static final String UPDATE = "UPDATE departmens SET address =? WHERE id=?";
    private static final String DELETE = "DELETE FROM departments WHERE id=?";


    public Department get(int id) {
        logger.info("Department returned");
        return jdbcTemplate.queryForObject(GET,
                mapper,
                id);
    }

    public int insert(Department department) {
        return jdbcTemplate.update(INSERT,
                department.getAddress());
    }

    public void update(Department department) { logger.info("Department updated");
        jdbcTemplate.update(UPDATE,
                department.getAddress());
    }

    public void delete(Department department) {
        logger.info("Department is  deleted");
        jdbcTemplate.update(DELETE, department.getId());

    }

    private RowMapper<Department> mapper = new RowMapper<Department>(){

        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setAddress(resultSet.getString("address"));
            return department;


        }
    };
}
