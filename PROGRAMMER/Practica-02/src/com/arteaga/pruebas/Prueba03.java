package com.arteaga.pruebas;

import com.arteaga.beans.Categoria;
import com.arteaga.beans.Evento;
import com.arteaga.service.EventoService;
import com.arteaga.service.impl.EventoServiceImpl;
import com.arteaga.threads.CopiaSeguridad;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.nio.file.StandardOpenOption.*;

public class Prueba03 {
    public static void main(String[] args) {

        System.out.println("2C.  Prueba de generación de copia de seguridad de eventos en memoria");
        System.out.println("***************************");
        //Elegimos el tipo de memoria
        EventoService servicio = new EventoServiceImpl(0);

        Evento e1= new Evento(1,"Advanced Factories", LocalDate.of(2020,1,19),"Av.Bruselas 2343",20, Categoria.PLATINUM);
        Evento e2= new Evento(2,"Barcelona Cybersecurity Congress", LocalDate.of(2020,3,20),"Av. Amenazaga 2346",20, Categoria.GOLD);
        Evento e3= new Evento(3,"Digital Enterprise Show", LocalDate.of(2020,4,10),"Av. Venezuela 3423",20, Categoria.SILVER);
        Evento e4= new Evento(4,"IoT Solutions World Congress", LocalDate.of(2020,6,5),"Av. Javier Prado 2343",20, Categoria.PLATINUM);
        Evento e5= new Evento(5,"Global Robot Expo", LocalDate.of(2020,7,7),"Av. Alfonso Ugarte 2523",20, Categoria.GOLD);
        Evento e6= new Evento(6,"Smart City Expo World Congress", LocalDate.of(2020,9,9),"Jr. El Derbi 2362",20, Categoria.SILVER);

        //Grabamos eventos en memoria
        servicio.grabar(e1);
        servicio.grabar(e2);
        servicio.grabar(e3);
        servicio.grabar(e4);
        servicio.grabar(e5);
        servicio.grabar(e6);

        System.out.println("Lista de eventos en memoria");
        System.out.println("************************");
        servicio.listar().stream().forEach((evento) -> {
            System.out.println(evento);
        });

        CopiaSeguridad thread= new CopiaSeguridad();
        thread.setEventos(servicio.listar());
        thread.start();
    }
}
