package com.arteaga.practica04.dao.impl;

import com.arteaga.practica04.dao.ClienteDao;

public class DaoFactory {

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {
        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public ClienteDao getClienteDao(int tipo){
        switch(tipo){
            case 1: return new ClienteDaoImpl();
            default: return null;
        }
    }
}
