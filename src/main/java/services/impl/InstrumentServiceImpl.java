package services.impl;

import components.Instrument;
import dao.DepartmentDAO;
import dao.InstrumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import services.InstrumentService;

/**
 * Created by nazar on 11.04.17.
 */
public class InstrumentServiceImpl implements InstrumentService {
    @Autowired
    private InstrumentDAO instrumentDAO;
    private static Logger logger = LoggerFactory.getLogger(InstrumentServiceImpl.class.getSimpleName());
    public Instrument get(int id) {
        logger.info("Gettting instrument by id");
        return instrumentDAO.get(id);
    }

    public int insert(Instrument instrument) {
        logger.info("Insert instrument");
        return instrumentDAO.insert(instrument);
    }

    public void update(Instrument instrument) {
        logger.info("update instrumentt");
        instrumentDAO.update(instrument);

    }

    public void remove(Instrument instrument) {
        logger.info("Instrument is removed");
        instrumentDAO.delete(instrument);

    }
}
