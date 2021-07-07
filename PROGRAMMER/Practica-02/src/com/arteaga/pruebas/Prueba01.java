package com.arteaga.pruebas;

import com.arteaga.beans.Categoria;
import com.arteaga.beans.Evento;
import com.arteaga.service.EventoService;
import com.arteaga.service.impl.EventoServiceImpl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class Prueba01 {
    public static void main(String[] args) {
        System.out.println("2A. Prueba de crear eventos y que demuestre que no se pueden traslapar:");
        System.out.println("***************************");
        EventoService servicio = new EventoServiceImpl(1);

        Evento e1= new Evento(1,"Advanced Factories", LocalDate.of(2020,1,19),"Av.Bruselas 2343",20, Categoria.PLATINUM);
        Evento e2= new Evento(2,"Barcelona Cybersecurity Congress", LocalDate.of(2020,3,20),"Av. Amenazaga 2346",20, Categoria.GOLD);
        Evento e3= new Evento(3,"Digital Enterprise Show", LocalDate.of(2020,4,10),"Av. Venezuela 3423",20, Categoria.SILVER);
        Evento e4= new Evento(4,"IoT Solutions World Congress", LocalDate.of(2020,6,5),"Av. Javier Prado 2343",20, Categoria.PLATINUM);
        Evento e5= new Evento(5,"Global Robot Expo", LocalDate.of(2020,7,7),"Av. Alfonso Ugarte 2523",20, Categoria.GOLD);
        Evento e6= new Evento(6,"Smart City Expo World Congress", LocalDate.of(2020,9,9),"Jr. El Derbi 2362",20, Categoria.SILVER);
        Evento e7= new Evento(7,"Iot projects", LocalDate.of(2020,4,2),"Av. Arequipa 2356",20, Categoria.PLATINUM);
        Evento e8= new Evento(8,"Artificial Intelligence Congress", LocalDate.of(2020,12,28),"Av. Universitaria",20, Categoria.GOLD);
        Evento e9= new Evento(9,"Robotics Projects", LocalDate.of(2020,10,8),"Av. Priale 2345",20, Categoria.SILVER);
        Evento e10= new Evento(10,"Advanced Technologies", LocalDate.of(2020,1,2),"Av. Ramirez 2345",20, Categoria.PLATINUM);
        Evento e11= new Evento(11,"Last Technologies", LocalDate.of(2020,3,27),"Av. Ramirez 2345",20, Categoria.PLATINUM);
        Evento e12= new Evento(12,"Digital Trends", LocalDate.of(2020,4,6),"Av. Ramirez 2345",20, Categoria.GOLD);
        Evento e13= new Evento(13,"Robotics", LocalDate.of(2020,6,2),"Av. Ramirez 2345",20, Categoria.PLATINUM);
        Evento e14= new Evento(14,"Last Frameworks", LocalDate.of(2020,4,21),"Av. Ramirez 2345",20, Categoria.GOLD);
        Evento e15= new Evento(15,"Smart City World", LocalDate.of(2020,2,10),"Av. Ramirez 2345",20, Categoria.SILVER);


        servicio.grabar(e1);
        servicio.grabar(e2);
        servicio.grabar(e3);
        servicio.grabar(e4);
        servicio.grabar(e5);
        servicio.grabar(e6);
        servicio.grabar(e7);
        servicio.grabar(e8);
        servicio.grabar(e9);
        servicio.grabar(e10);
        servicio.grabar(e11);
        servicio.grabar(e12);
        servicio.grabar(e13);
        servicio.grabar(e14);
        servicio.grabar(e15);

        System.out.println("Lista de eventos creados");
        System.out.println("************************");
        servicio.listar().stream().forEach((evento) -> {
            System.out.println(evento);
        });


    }

}
