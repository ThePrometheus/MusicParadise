package services;

import components.Department;

/**
 * Created by nazar on 11.04.17.
 */
public interface DepartmentService {
    Department get(int id);
    int insert(Department department);
    void update(Department department );
    void remove(Department department );

}
