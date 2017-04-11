package services;

import components.Instrument;

/**
 * Created by nazar on 11.04.17.
 */
public interface InstrumentService {
    Instrument get(int id);
    int insert(Instrument instrument);
    void update(Instrument oinstrument);
    void remove(Instrument instrument );
}
