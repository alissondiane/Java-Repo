package com.arteaga.pruebas;

import com.arteaga.entidades.Asistente;
import com.arteaga.entidades.Evento;
import com.arteaga.entidades.Expositor;

import java.util.ArrayList;
import java.util.List;

import static com.arteaga.util.MisConstantes.*;

public class Prueba04 {
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
        System.out.println("======Prueba 04 - Listado de de participantes======");

        List<Asistente> asistentesPlatinum = new ArrayList<>();
        List<Asistente> asistentesGold =  new ArrayList<>();
        List<Asistente> asistentesVip =  new ArrayList<>();

        for(Evento e:listadoEventos){
            if(e.getCodigoUbicacion() == UBICACION_PLATINUM){
                for(Asistente a : e.getListaAsistentes()){
                   asistentesPlatinum.add(a);
                }
            }
            if(e.getCodigoUbicacion() == UBICACION_GOLD){
                for(Asistente a : e.getListaAsistentes()){
                    asistentesGold.add(a);
                }
            }
            if(e.getCodigoUbicacion() == UBICACION_VIP){
                for(Asistente a : e.getListaAsistentes()){
                    asistentesVip.add(a);
                }
            }
        }

        System.out.println("\n== Listado de asistentes que pagaron en PLATINUM ==");
        System.out.println("\nCodigo | Nombres | Apellidos | Telefono | Correo");
        System.out.println("----------------------------------------------------------------");
        for(Asistente a:asistentesPlatinum){
            System.out.println(a.getCodigo()+"\t|"+a.getNombre()+"\t|"+a.getApellidos()+"\t|"+a.getTelefono()+"\t|"+a.getCorreo());
        }
        System.out.println("\n== Listado de asistentes que pagaron en GOLD ==");
        System.out.println("\nCodigo | Nombres | Apellidos | Telefono | Correo");
        System.out.println("----------------------------------------------------------------");
        for(Asistente a:asistentesGold){
            System.out.println(a.getCodigo()+"\t|"+a.getNombre()+"\t|"+a.getApellidos()+"\t|"+a.getTelefono()+"\t|"+a.getCorreo());
        }
        System.out.println("\n== Listado de asistentes que pagaron en VIP ==");
        System.out.println("\nCodigo | Nombres | Apellidos | Telefono | Correo");
        System.out.println("----------------------------------------------------------------");
        for(Asistente a:asistentesVip){
            System.out.println(a.getCodigo()+"\t|"+a.getNombre()+"\t|"+a.getApellidos()+"\t|"+a.getTelefono()+"\t|"+a.getCorreo());
        }

    }
}
