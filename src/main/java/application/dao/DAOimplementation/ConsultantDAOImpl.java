package application.dao.DAOimplementation;

import application.components.Consultant;
import application.dao.ConsultantDAO;

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
public class ConsultantDAOImpl implements ConsultantDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static Logger logger = LoggerFactory.getLogger(ConsultantDAOImpl.class.getSimpleName());
    private static final String GET = "SELECT  * FROM consultants WHERE login=?";
    private static final String INSERT = "INSERT INTO consultants (login,surname,firstname,middlename,birth_date,tel_number,salary,department) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE consultants SET surname=?,firstname=?,middlename=?,birth_date=?,tel_number=?,salary=?,department=? WHERE login=?";
    private static final String DELETE = "DELETE FROM consultants WHERE login=?";
    private static final  String GET_BY_ID = "SELECT  * FROM consultants WHERE id=?";
    private static final String GET_BY_ORDER_ID = "SELECT FROM consultants c WHERE c.login IN (SELECT o.consultant FROM orders o WHERE o.id=?) ";
private static final String SUPER_CONSULTANT ="SELECT * FROM consultants c WHERE NOT EXISTS(SELECT o.id FROM orders o WHERE o.consultant=c.id AND NOT EXISTS (SELECT * FROM instruments i WHERE c.department!=i.department ))";
    public Consultant get(String login ) {
        logger.info("Conslutant retrieved");
        return jdbcTemplate.queryForObject(GET,mapper,login);
    }



    public int insert(Consultant consultant) {
        logger.info("Client inserted");
        return jdbcTemplate.update(INSERT,

                consultant.getSalary(),
                consultant.getFirstname(),
                consultant.getMiddlename(),
                consultant.getBirth_date(),
                consultant.getTelephone_number(),
                consultant.getSalary(),

                consultant.getDepartment_id());
    }

    public void update(Consultant consultant) {
        logger.info("Consultant updated");
        jdbcTemplate.update(UPDATE,

                consultant.getSurname(),
                consultant.getFirstname(),
                consultant.getMiddlename(),
                consultant.getBirth_date(),
                consultant.getTelephone_number(),
                consultant.getSalary(),
                consultant.getDepartment_id());

    }

        public void delete(Consultant consultant) {
        logger.info("Consultant is  deleted");
        jdbcTemplate.update(DELETE, consultant.getId());

    }
    public Consultant getById(int id){
      return   jdbcTemplate.queryForObject(GET_BY_ID,mapper,id);
    }

    public Consultant getConsultantByOrderId(int id) {
        List<Consultant> resp = jdbcTemplate.query(GET_BY_ORDER_ID, mapper, id);
        return (resp.isEmpty())?null:resp.get(0);
    }



    private RowMapper<Consultant> mapper = new RowMapper<Consultant>() {
        public Consultant mapRow(ResultSet resultSet, int i) throws SQLException {
            Consultant consultant = new Consultant();
            consultant.setId(resultSet.getInt("id"));

            consultant.setSurname(resultSet.getString("surname"));
            consultant.setFirstname(resultSet.getString("firstname"));
            consultant.setMiddlename(resultSet.getString("middlename"));

            consultant.setBirth_date((resultSet.getString("birth_date")));
            consultant.setTelephone_number(resultSet.getString("tel_number"));
            consultant.setSalary(resultSet.getShort("salary"));

            consultant.setDepartment_id(resultSet.getShort("department"));

           return consultant;

        }






    };
}



