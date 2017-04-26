package application.dao;

import application.components.Department;

import java.util.List;

/**
 * Created by nazar on 10.04.17.
 */
public interface DepartmentDAO {
    Department get(int id);
    int insert(Department department);
    void update(Department department);
    void delete(Department department);
    public List<Department> getAll();



}
