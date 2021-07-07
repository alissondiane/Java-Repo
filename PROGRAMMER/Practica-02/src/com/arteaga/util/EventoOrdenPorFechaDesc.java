package com.arteaga.util;

import com.arteaga.beans.Evento;

import java.util.Comparator;

public class EventoOrdenPorFechaDesc implements Comparator<Evento> {
    @Override
    public int compare(Evento o1, Evento o2) {
        int result = o1.getFecha().compareTo(o2.getFecha());
        if (result != 0) { return result;}
        else {
            return 0;
        }
    }
}
