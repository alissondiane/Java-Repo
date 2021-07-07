package com.arteaga.beans;

import java.time.LocalDate;

public class Evento {
    private int id;
    private String nombre;
    private LocalDate fecha;
    private String direccion;
    private int capacidad;
    private Categoria categoria;
    private Double costo;

    public Evento(){

    }

    public Evento(int id, String nombre, LocalDate fecha, String direccion, int capacidad, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.costo = this.categoria.getCosto();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        this.costo = this.categoria.getCosto();
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", direccion='" + direccion + '\'' +
                ", capacidad=" + capacidad +
                ", categoria=" + categoria +
                ", costo=" + costo +
                '}';
    }
    public void printSummary(){
        System.out.printf(
                "Id: " + id +
                        " Nombre: " + nombre +
                        " Fecha: " + fecha +
                        " Dirección: " + direccion +
                        " Categoria: " + categoria +
                        " Costo: $%,9.2f %n", costo
        );
    }
}
