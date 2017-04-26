package application.services;

import application.components.Instrument;

import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
public interface InstrumentService {
    Instrument get(int id);
    int insert(Instrument instrument);
    void update(Instrument oinstrument);
    void remove(Instrument instrument );
    List<Instrument> getAll();
}
