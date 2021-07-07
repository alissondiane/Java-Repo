package com.arteaga.pruebas;

import com.arteaga.beans.Categoria;
import com.arteaga.beans.Evento;
import com.arteaga.service.EventoService;
import com.arteaga.service.impl.EventoServiceImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prueba02 {
    public static void main(String[] args) {

        EventoService servicio = new EventoServiceImpl(1);

        System.out.println("2B.Prueba de creación de eventos para varios periodos y mostrar eventos por periodos:");
        System.out.println("***************************");

        System.out.println("\nEventos del 2020-Q1");
        servicio.listar().stream().filter(
                e-> e.getFecha().getMonthValue() <= 3
        ).forEach(e-> e.printSummary());

        System.out.println("\nEventos del 2020-Q2");
        servicio.listar().stream().filter(
                e-> e.getFecha().getMonthValue() >3 && e.getFecha().getMonthValue() <=6
        ).forEach(e-> e.printSummary());

        System.out.println("\nEventos del 2020-Q3");
        servicio.listar().stream().filter(
                e-> e.getFecha().getMonthValue() >6 && e.getFecha().getMonthValue() <=9
        ).forEach(e-> e.printSummary());

        System.out.println("\nEventos del 2020-Q4");
        servicio.listar().stream().filter(
                e-> e.getFecha().getMonthValue() >9 && e.getFecha().getMonthValue() <=12
        ).forEach(e-> e.printSummary());

    }
}
