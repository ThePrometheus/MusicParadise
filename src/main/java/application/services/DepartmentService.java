package application.services;

import application.components.Department;

import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
public interface DepartmentService {
    Department get(int id);
    int insert(Department department);
    void update(Department department );
    void remove(Department department );
    public List<Department> getAll();

}
