package dao.DAOimplementation;

import components.Consultant;
import dao.ConsultantDAO;

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
public class ConsultantDAOImpl implements ConsultantDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static Logger logger = LoggerFactory.getLogger(ConsultantDAOImpl.class.getSimpleName());
    private static final String GET = "SELECT  * FROM consultants WHERE id=?";
    private static final String INSERT = "INSERT INTO consultants (encrypted_password,surname,firstname,middlename,birth_date,tel_number,salary,department,login,role) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE consultants SET encrypted_password=?,surname=?,firstname=?,middlename=?,birth_date=?,tel_number=?,salary=?,department=?,login=?,role=? WHERE id=?";
    private static final String DELETE = "DELETE FROM consutlants WHERE id=?";



    public Consultant get(int id) {
        logger.info("Conslutant retrieved");
        return jdbcTemplate.queryForObject(GET,mapper,id);
    }

    public int insert(Consultant consultant) {
        logger.info("Client inserted");
        return jdbcTemplate.update(INSERT,
                consultant.getPassword(),
                consultant.getSalary(),
                consultant.getFirstname(),
                consultant.getMiddlename(),
                consultant.getBirth_date(),
                consultant.getTelephone_number(),
                consultant.getSalary(),
                consultant.getLogin(),
                consultant.getRole(),
                consultant.getDepartment_id());
    }

    public void update(Consultant consultant) {
        logger.info("Consultant updated");
        jdbcTemplate.update(UPDATE,
                consultant.getPassword(),
                consultant.getSurname(),
                consultant.getFirstname(),
                consultant.getMiddlename(),
                consultant.getBirth_date(),
                consultant.getTelephone_number(),
                consultant.getSalary(),
                consultant.getLogin(),
                consultant.getRole());
    }

        public void delete(Consultant consultant) {
        logger.info("Consultant is  deleted");
        jdbcTemplate.update(DELETE, consultant.getId());

    }

    private RowMapper<Consultant> mapper = new RowMapper<Consultant>() {
        public Consultant mapRow(ResultSet resultSet, int i) throws SQLException {
            Consultant consultant = new Consultant();
            consultant.setId(resultSet.getInt("id"));
            consultant.setPassword(resultSet.getString("encrypted_password"));
            consultant.setSurname(resultSet.getString("surname"));
            consultant.setFirstname(resultSet.getString("firstname"));
            consultant.setMiddlename(resultSet.getString("middlename"));
            consultant.setRole(resultSet.getString("role"));
            consultant.setBirth_date((resultSet.getString("birth_date")));
            consultant.setTelephone_number(resultSet.getString("tel_number"));
            consultant.setSalary(resultSet.getShort("salary"));
            consultant.setLogin(resultSet.getString("login"));
            consultant.setDepartment_id(resultSet.getShort("department"));

           return consultant;

        }






    };
}



