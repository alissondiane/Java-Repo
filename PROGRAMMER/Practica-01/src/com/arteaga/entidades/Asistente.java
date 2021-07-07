package com.arteaga.entidades;

import javax.sound.sampled.AudioInputStream;
import java.util.ArrayList;
import java.util.List;

public class Asistente {
    private String codigo;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String direccion;

    public static class Builder{

        private String codigo="";
        private String nombre="";
        private String apellidos="";
        private String correo = "";
        private String telefono = "";
        private String direccion = "";


        public Asistente.Builder codigo(String codigo){
            this.codigo = codigo;
            return this;
        }
        public Asistente.Builder nombre(String nombre){
            this.nombre = nombre;
            return this;
        }

        public Asistente.Builder apellidos(String apellidos){
            this.apellidos = apellidos;
            return this;
        }
        public Asistente.Builder correo(String correo){
            this.correo =  correo;
            return this;
        }

        public Asistente.Builder telefono(String telefono){
            this.telefono = telefono;
            return this;
        }
        public Asistente.Builder direccion(String direccion){
            this.direccion = direccion;
            return this;
        }
        public Asistente build(){
            return new Asistente(this);
        }
    }

    private Asistente(Asistente.Builder builder){
        codigo = builder.codigo;
        nombre = builder.nombre;
        apellidos = builder.apellidos;
        correo = builder.correo;
        telefono = builder.telefono;
        direccion = builder.direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static List<Asistente> createShortList(){
        List<Asistente> asistentes = new ArrayList<>();

        asistentes.add(
                new Asistente.Builder()
                        .codigo("A001")
                        .nombre("Luis Mario")
                        .apellidos("Cardenas Ramirez")
                        .correo("luis@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Jazmines 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A002")
                        .nombre("Maria Sofia")
                        .apellidos("Arteaga Diaz")
                        .correo("maria@gmail.com")
                        .telefono("676345261")
                        .direccion("Av.Venezuela 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A003")
                        .nombre("Fernando Luis")
                        .apellidos("Perez Mecca")
                        .correo("fernando@gmail.com")
                        .telefono("946345261")
                        .direccion("Av.Arequipa 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A004")
                        .nombre("Lorena Rosa")
                        .apellidos("Manrique Ramirez")
                        .correo("lorena@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Girasoles 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A005")
                        .nombre("Alexandra Roxana")
                        .apellidos("Riva Mariategui")
                        .correo("alexandra@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Priale 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A006")
                        .nombre("Marcos Jose")
                        .apellidos("Paz Riquez")
                        .correo("marcos@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Universitaria 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A007")
                        .nombre("Ricardo")
                        .apellidos("Suarez Rengifo")
                        .correo("ricardo@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Colonial 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A008")
                        .nombre("Leonel Jose")
                        .apellidos("Campos Rios")
                        .correo("leonel@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Tomas Valle 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A009")
                        .nombre("Luciana Rosalia")
                        .apellidos("Ross Ramos")
                        .correo("lucian01@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Angamos 2343")
                        .build()
        );
        asistentes.add(
                new Asistente.Builder()
                        .codigo("A010")
                        .nombre("Lucas Diego")
                        .apellidos("Rios Ramos")
                        .correo("lucas@gmail.com")
                        .telefono("876345261")
                        .direccion("Av.Tupac Amaru 2343")
                        .build()
        );
        return asistentes;
    }
}
