package services;

import components.Consultant;

/**
 * Created by nazar on 11.04.17.
 */
public interface ConsultantService {
    Consultant get(int id);
    int insert(Consultant consultant);
    void update(Consultant consultant );
    void remove(Consultant consultant );

}