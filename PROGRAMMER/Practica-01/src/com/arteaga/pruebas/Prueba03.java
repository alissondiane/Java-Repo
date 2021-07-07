package com.arteaga.pruebas;

import com.arteaga.entidades.Asistente;
import com.arteaga.entidades.Evento;
import com.arteaga.entidades.Expositor;

import java.util.List;

public class Prueba03 {
    public static void main(String[] args) {
        //1.B. Usando patron builder
        List<Evento> listadoEventos = Evento.createShortList();
        List<Expositor> listadoExpositores = Expositor.createShortList();
        List<Asistente> Asistentes = Asistente.createShortList();
        //Asigno a los eventos sus expositores
        listadoEventos.get(0).setExpositor(listadoExpositores.get(0));
        listadoEventos.get(1).setExpositor(listadoExpositores.get(1));
        listadoEventos.get(2).setExpositor(listadoExpositores.get(2));
        listadoEventos.get(3).setExpositor(listadoExpositores.get(3));
        listadoEventos.get(4).setExpositor(listadoExpositores.get(4));
        listadoEventos.get(5).setExpositor(listadoExpositores.get(5));
        //Asigno los asistentes a los eventos
        listadoEventos.get(0).getListaAsistentes().add(Asistentes.get(0));
        listadoEventos.get(0).getListaAsistentes().add(Asistentes.get(1));

        listadoEventos.get(1).getListaAsistentes().add(Asistentes.get(2));

        listadoEventos.get(2).getListaAsistentes().add(Asistentes.get(3));

        listadoEventos.get(3).getListaAsistentes().add(Asistentes.get(4));
        listadoEventos.get(3).getListaAsistentes().add(Asistentes.get(5));

        listadoEventos.get(4).getListaAsistentes().add(Asistentes.get(6));

        listadoEventos.get(5).getListaAsistentes().add(Asistentes.get(7));
        listadoEventos.get(5).getListaAsistentes().add(Asistentes.get(8));
        listadoEventos.get(5).getListaAsistentes().add(Asistentes.get(9));

        //2C: Listado de eventos y el total recaudado por cada evento;
        System.out.println("======Prueba 03 - Listado de eventos======");

        for(Evento e:listadoEventos){
            System.out.println("****************************************");
            System.out.println("Evento: "+e.getTitulo());
            System.out.println("Total Recaudado: "+(e.calcularMontoTotal()-e.calcularMontoDescuento())*e.getListaAsistentes().size());
        }


    }
}
