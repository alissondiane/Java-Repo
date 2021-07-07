package com.arteaga.dao.impl;

import com.arteaga.dao.EventoDao;
import static com.arteaga.util.Util.*;

public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {
        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public EventoDao getEventoDao(int tipo){
        switch(tipo){
            case MEMORY: return new EventoDaoMemory();
            case FILE: return new EventoDaoFile();
            default: return null;
        }
    }
}
