package com.arteaga.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.arteaga.util.MisConstantes.*;

public class Evento {
    private String titulo;
    private int duracion;
    private Expositor expositor;
    private String horaIngreso;
    private String horaSalida;
    private boolean temporadaAlta;
    private char codigoUbicacion;
    private List<Asistente> listaAsistentes = new ArrayList<>();

    public static class Builder{

        private String titulo="";
        private int duracion=0;
        private Expositor expositor = new Expositor();
        private String horaIngreso = "15:00";
        private String horaSalida  = "16:30";
        private boolean temporadaAlta = false;
        private char codigoUbicacion = 'P';

        public Evento.Builder titulo(String titulo){
            this.titulo = titulo;
            return this;
        }
        public Evento.Builder duracion(int duracion){
            this.duracion = duracion;
            return this;
        }

        public Evento.Builder expositor (Expositor expositor){
            this.expositor = expositor;
            return this;
        }
        public Evento.Builder horaIngreso(String horaIngreso){
            this.horaIngreso =  horaIngreso;
            return this;
        }

        public Evento.Builder horaSalida(String horaSalida){
            this.horaSalida = horaSalida;
            return this;
        }
        public Evento.Builder temporadaAlta(boolean temporadaAlta){
            this.temporadaAlta = temporadaAlta;
            return this;
        }
        public Evento.Builder codigoUbicacion(char codigoUbicacion){
            this.codigoUbicacion = codigoUbicacion;
            return this;
        }
        public Evento build(){
            return new Evento(this);
        }
    }

    private Evento(){
        super();
    }

    private Evento(Evento.Builder builder){
        titulo = builder.titulo;
        duracion = builder.duracion;
        expositor = builder.expositor;
        horaIngreso = builder.horaIngreso;
        horaSalida = builder.horaSalida;
        temporadaAlta = builder.temporadaAlta;
        codigoUbicacion = builder.codigoUbicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Expositor getExpositor() {
        return expositor;
    }

    public void setExpositor(Expositor expositor) {
        this.expositor = expositor;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public boolean isTemporadaAlta() {
        return temporadaAlta;
    }

    public void setTemporadaAlta(boolean temporadaAlta) {
        this.temporadaAlta = temporadaAlta;
    }

    public char getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(char codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public List<Asistente> getListaAsistentes() {
        return listaAsistentes;
    }
    public void setListaAsistentes(List<Asistente> listaAsistentes) {
        this.listaAsistentes = listaAsistentes;
    }

    public static List<Evento> createShortList(){
        List<Evento> eventos = new ArrayList<>();

        eventos.add(
                new Builder()
                        .titulo("Advanced Factories")
                        .duracion(2)
                        .expositor(new Expositor())
                        .horaIngreso("10:30")
                        .horaSalida("16:30")
                        .temporadaAlta(true)
                        .codigoUbicacion(UBICACION_PLATINUM)
                        .build()
        );
        eventos.add(
                new Builder()
                        .titulo("Barcelona Cybersecurity Congress")
                        .duracion(3)
                        .expositor(new Expositor())
                        .horaIngreso("9:30")
                        .horaSalida("16:30")
                        .temporadaAlta(false)
                        .codigoUbicacion(UBICACION_GOLD)
                        .build()
        );
        eventos.add(
                new Builder()
                        .titulo("Digital Enterprise Show")
                        .duracion(4)
                        .expositor(new Expositor())
                        .horaIngreso("13:00")
                        .horaSalida("18:30")
                        .temporadaAlta(true)
                        .codigoUbicacion(UBICACION_VIP)
                        .build()
        );
        eventos.add(
                new Builder()
                        .titulo("IoT Solutions World Congress")
                        .duracion(1)
                        .expositor(new Expositor())
                        .horaIngreso("8:00")
                        .horaSalida("14:00")
                        .temporadaAlta(false)
                        .codigoUbicacion(UBICACION_PLATINUM)
                        .build()
        );
        eventos.add(
                new Builder()
                        .titulo("Global Robot Expo")
                        .duracion(6)
                        .expositor(new Expositor())
                        .horaIngreso("11:30")
                        .horaSalida("16:30")
                        .temporadaAlta(true)
                        .codigoUbicacion(UBICACION_GOLD)
                        .build()
        );
        eventos.add(
                new Builder()
                        .titulo("Smart City Expo World Congress")
                        .duracion(2)
                        .expositor(new Expositor())
                        .horaIngreso("10:30")
                        .horaSalida("15:30")
                        .temporadaAlta(false)
                        .codigoUbicacion(UBICACION_PLATINUM)
                        .build()
        );
        return eventos;
    }

    public double calcularCostoIngreso(){
        switch(this.codigoUbicacion){
            case UBICACION_PLATINUM: return COSTO_PLATINUM;
            case UBICACION_GOLD: return COSTO_GOLD;
            case UBICACION_VIP: return COSTO_VIP;
            default: return 0;
        }
    }
    public double calcularMontoTotal(){
        return (1+PORCENTAJE_IGV)*calcularCostoIngreso();
        //return calcularCostoIngreso()+ PORCENTAJE_IGV*calcularCostoIngreso();
    }
    public double calcularMontoDescuento(){
        return (this.temporadaAlta?Math.round(PORCENTAJE_TEMPORADA_ALTA*calcularMontoTotal()*100.0)/100.0:Math.round(PORCENTAJE_TEMPORADA_BAJA*calcularMontoTotal()*100.0/100.0));
    }

}
