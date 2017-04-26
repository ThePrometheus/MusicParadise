package application.dao;

import application.components.Instrument;

import java.util.List;

/**
 * Created by nazar on 10.04.17.
 */
public interface InstrumentDAO {
    Instrument get(int id);
    int insert(Instrument instrument);
    void update(Instrument instrument);
    void delete(Instrument instrument);
    List<Instrument> getAll();

}
