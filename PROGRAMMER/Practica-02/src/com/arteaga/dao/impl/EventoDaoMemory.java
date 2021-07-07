package com.arteaga.dao.impl;

import com.arteaga.beans.Evento;
import com.arteaga.dao.EventoDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventoDaoMemory implements EventoDao {
    private List<Evento> lEvento;

    public EventoDaoMemory() {
        lEvento = new ArrayList<>();
    }

    @Override
    public void create(Evento t) {
        if(find(t.getId())==null)
            lEvento.add(t);
    }

    @Override
    public Evento find(Object id) {
        for(Evento evento:lEvento){
            if(evento.getId()==(int)id)
                return evento;
        }
        return null;
    }

    @Override
    public List<Evento> findAll() {
        return lEvento;
    }

    @Override
    public void update(Evento t) {
        for(int ind=0; ind<lEvento.size(); ind++){
            if(lEvento.get(ind).getId()==t.getId()){
                lEvento.set(ind,t);
                break;
            }
        }
    }

    @Override
    public void delete(Object id) {
        lEvento.remove(find(id));
    }

    @Override
    public List<Evento> orderByFechaDesc() {
        return null;
    }

    @Override
    public List<Evento> orderByFechaAsc() {
        return null;
    }

    @Override
    public List<Evento> filterByRangoFecha(LocalDate desde, LocalDate hasta) {
        return null;
    }

    @Override
    public void visualizarPorDetalle() {
        
    }
}
