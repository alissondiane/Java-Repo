package com.arteaga.dao;

import com.arteaga.beans.Evento;

import java.time.LocalDate;
import java.util.List;

public interface EventoDao extends EntidadDao<Evento>{
    public List<Evento> orderByFechaDesc();
    public List<Evento> orderByFechaAsc();
    public List<Evento> filterByRangoFecha(LocalDate desde, LocalDate hasta);
    public void visualizarPorDetalle();
}
