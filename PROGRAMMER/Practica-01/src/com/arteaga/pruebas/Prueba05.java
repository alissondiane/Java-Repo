package com.arteaga.pruebas;

import com.arteaga.entidades.Asistente;
import com.arteaga.entidades.Evento;
import com.arteaga.entidades.Expositor;

import java.util.List;

import static com.arteaga.util.MisConstantes.UBICACION_PLATINUM;
import static com.arteaga.util.MisConstantes.UBICACION_VIP;

public class Prueba05 {
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

        //2D: Listado de eventos y sus precios ubicados por ubicacion;
        System.out.println("======Prueba 05 - Listado sueldo a pagar a expositores en charlas VIP======");

        System.out.println("== Listado de expositores en charlas VIP ==");
        System.out.println("\nCodigo | Nombre | Apellidos | Sueldo");
        System.out.println("----------------------------------------------------------------");
        listadoEventos.stream()
                .filter(e -> e.getCodigoUbicacion() == UBICACION_VIP)
                .forEach(
                        e -> System.out.println( e.getExpositor().getCodigo() + " | " +e.getExpositor().getNombre()
                                +" | " +e.getExpositor().getApellidos()+" | " +e.getExpositor().getSueldo()+" $"
                        )
                );
    }
}
