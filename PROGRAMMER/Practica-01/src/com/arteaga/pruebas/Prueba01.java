package com.arteaga.pruebas;

import com.arteaga.entidades.Asistente;
import com.arteaga.entidades.Evento;
import com.arteaga.entidades.Expositor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Prueba01 {
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

        //2A: Listado de manera ordenado por titulo descendiente, expositor y asistentes.

        Comparator<Integer> comparador = Collections.reverseOrder();

        //Ordenar de forma descendente por titulo
        Collections.sort(listadoEventos, (o1, o2) -> o2.getTitulo().compareTo(o1.getTitulo()));

        System.out.println("======Prueba 01 - Listado de eventos======");
        for(Evento e:listadoEventos){
            System.out.println("****************************************");
            System.out.println("Evento: "+e.getTitulo());
            System.out.println("Expositor: "+e.getExpositor().getNombre());
            System.out.println("Asistentes:");
            for(Asistente a : e.getListaAsistentes()){
                System.out.println(a.getCodigo()+"\t"+a.getNombre()+"\t"+a.getApellidos());
            }
        }

    }
}
