package services.impl;

import components.Department;
import dao.ConsultantDAO;
import dao.DepartmentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import services.DepartmentService;

/**
 * Created by nazar on 11.04.17.
 */
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;
    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class.getSimpleName());
    public Department get(int id) {
        logger.info("Gettting department by id");
        return departmentDAO.get(id);
    }

    public int insert(Department department) {
        logger.info("Insert department");
        return departmentDAO.insert(department);
    }

    public void update(Department department) {
        logger.info("update department");
        departmentDAO.update(department);

    }

    public void remove(Department department) {
        logger.info("Department is removed");
        departmentDAO.delete(department);

    }
}
