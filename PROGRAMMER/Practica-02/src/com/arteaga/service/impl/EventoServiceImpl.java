package com.arteaga.service.impl;

import com.arteaga.beans.Evento;
import com.arteaga.dao.EventoDao;
import com.arteaga.dao.impl.DaoFactory;
import com.arteaga.service.EventoService;

import java.time.LocalDate;
import java.util.List;

public class EventoServiceImpl implements EventoService {

    private EventoDao dao;

    public EventoServiceImpl(int opc) {
        DaoFactory fabrica = DaoFactory.getInstance();
        dao = fabrica.getEventoDao(opc);
    }

    @Override
    public void grabar(Evento evento) {
        dao.create(evento);
    }

    @Override
    public Evento buscar(Object id) {
        return dao.find(id);
    }

    @Override
    public List<Evento> listar() {
        return dao.findAll();
    }

    @Override
    public void actualizar(Evento evento) {
        dao.update(evento);
    }

    @Override
    public void borrar(Object id) {
        dao.delete(id);
    }

    @Override
    public List<Evento> ordenarPorFechaDescendente() {
        return dao.orderByFechaDesc();
    }

    @Override
    public List<Evento> ordenarPorFechaAscendente() {
        return dao.orderByFechaAsc();
    }

    @Override
    public List<Evento> filtrarPorRangoFechas(LocalDate desde, LocalDate hasta) {
        return dao.filterByRangoFecha(desde,hasta);
    }

    @Override
    public void visualizarPorDetalle() {
        dao.visualizarPorDetalle();
    }
}
