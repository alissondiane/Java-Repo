package com.arteaga.pruebas;

import com.arteaga.beans.Categoria;
import com.arteaga.beans.Evento;
import com.arteaga.service.EventoService;
import com.arteaga.service.impl.EventoServiceImpl;
import org.w3c.dom.events.EventException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Prueba04 {
    public static void main(String[] args) {
        System.out.println("2D.Prueba de reportes:");
        System.out.println("***************************");
        EventoService servicio = new EventoServiceImpl(1);

        System.out.println("1B.Mostrar lista de eventos ordenados por fecha ascendente y descendente");
        System.out.println("************************************************************************");

        System.out.println("\n== Lista de eventos ordenados por fecha descendente == ");
        servicio.ordenarPorFechaDescendente().stream().forEach((evento) -> {
            System.out.println("Nombre: " + evento.getNombre() + "Fecha: "+evento.getFecha());
        });

        System.out.println("\n == Lista de eventos ordenados por fecha ascendente ==");

        servicio.ordenarPorFechaAscendente().stream().forEach((evento) -> {
            System.out.println("Nombre: " + evento.getNombre() + "Fecha: "+evento.getFecha());
        });

        System.out.println("\n1C.Lista de eventos filtrados por fechas con rango (fecha inicial y fecha final)");
        System.out.println("************************************************************************");

        servicio.filtrarPorRangoFechas(LocalDate.of(2020,10,8)
                ,LocalDate.of(2020,12,20)).stream().forEach((evento) -> {
            System.out.println("Nombre: " + evento.getNombre() + " Fecha : "+evento.getFecha() + " Categoria: " +evento.getCategoria());
        });

        System.out.println("\n1D. Mostrar el nombre, mes, día, día de semana del evento con capacidad máxima y mínima.");
        System.out.println("************************************************************************");
        servicio.visualizarPorDetalle();

        System.out.println("\n1E. Mostrar el promedio, mínimo y máximo de costos de los eventos. La cantidad de eventos superiores al costo promedio.");
        System.out.println("************************************************************************");

        OptionalDouble costoPromedio;

        costoPromedio = servicio.listar().stream()
                .mapToDouble(e -> e.getCosto())
                .average();

        if (costoPromedio.isPresent()){
            System.out.printf("Costo Promedio de eventos: $%,6.2f %n",
                    costoPromedio.getAsDouble());
        }
        OptionalDouble costoMinimo;

        costoMinimo = servicio.listar().stream()
                .mapToDouble(e -> e.getCosto())
                 .min();

        if (costoMinimo.isPresent()){
            System.out.printf("Costo Minimo de eventos: $%,6.2f %n",
                    costoMinimo.getAsDouble());
        }
        OptionalDouble costoMaximo;

        costoMaximo = servicio.listar().stream()
                .mapToDouble(e -> e.getCosto())
                .max();

        if (costoMaximo.isPresent()){
            System.out.printf("Costo Máximo de eventos: $%,6.2f %n",
                    costoMaximo.getAsDouble());
        }
        long eventCount =
                servicio.listar().stream()
                        .filter(e -> e.getCosto() > costoPromedio.getAsDouble())
                        .count();

        System.out.println("Cantidad de eventos superiores al costo promedio: " + eventCount);

        System.out.println("\n1F.Halle");
        System.out.println("***********");
        System.out.println("1. El día de la semana y el mes en el que se hacen más eventos.");

        Map<Object, Long> gMapDiaSemana = new HashMap<>();

        // Collect Dia de semana
        gMapDiaSemana = servicio.listar().stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.getFecha().getDayOfWeek(), Collectors.counting()));

        Map<Object, Long> gMapMes = new HashMap<>();

        // Collect Dia de semana
        gMapMes = servicio.listar().stream()
                .collect(
                        Collectors.groupingBy(
                                e -> e.getFecha().getMonth(), Collectors.counting()));

        Object maxValor = Collections.max(gMapDiaSemana.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\n== Dia de la semana en el que se  hacen mas eventos == ");
        System.out.println(maxValor);

        Object maxMes = Collections.max(gMapMes.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\n== Mes en el que se hacen mas eventos == ");
        System.out.println(maxMes);

        System.out.println("\n2. Las cantidades de eventos por día y por mes.");

        System.out.println("\n== Eventos por mes==");
        gMapMes.forEach((k,v) ->
                System.out.println("Mes: " + k + " Cantidad: " + v)
        );
        System.out.println("\n== Eventos por dia de semana==");
        gMapDiaSemana.forEach((k,v) ->
                System.out.println("Dia de Semana: " + k + " Cantidad: " + v)
        );



    }
}
