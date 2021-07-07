package com.arteaga.service;

import com.arteaga.beans.Evento;

import java.time.LocalDate;
import java.util.List;

public interface EventoService {
    public void grabar(Evento evento);

    public Evento buscar(Object id);
    public List<Evento> listar();

    public void actualizar(Evento evento);
    public void borrar(Object id);

    public List<Evento> ordenarPorFechaDescendente();
    public List<Evento> ordenarPorFechaAscendente();
    public List<Evento> filtrarPorRangoFechas(LocalDate desde, LocalDate hasta);

    public void visualizarPorDetalle();

}
