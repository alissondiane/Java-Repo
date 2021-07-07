package com.arteaga.entidades;

import java.util.ArrayList;
import java.util.List;

import static com.arteaga.util.MisConstantes.*;
import static com.arteaga.util.MisConstantes.UBICACION_PLATINUM;

public class Expositor {
    private String codigo;
    private String nombre;
    private String apellidos;
    private int sueldo;
    private String correo;

    public static class Builder{

        private String codigo="";
        private String nombre="";
        private String apellidos="";
        private int sueldo=0;
        private String correo = "";


        public Expositor.Builder codigo(String codigo){
            this.codigo = codigo;
            return this;
        }
        public Expositor.Builder nombre(String nombre){
            this.nombre = nombre;
            return this;
        }

        public Expositor.Builder apellidos(String apellidos){
            this.apellidos = apellidos;
            return this;
        }
        public Expositor.Builder sueldo(int sueldo){
            this.sueldo =  sueldo;
            return this;
        }

        public Expositor.Builder correo(String correo){
            this.correo = correo;
            return this;
        }
        public Expositor build(){
            return new Expositor(this);
        }
    }

   public Expositor(){

   }

    private Expositor(Expositor.Builder builder){
        codigo = builder.codigo;
        nombre = builder.nombre;
        apellidos = builder.apellidos;
        sueldo = builder.sueldo;
        correo = builder.correo;
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int suelod) {
        this.sueldo = sueldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static List<Expositor> createShortList(){
        List<Expositor> expositores = new ArrayList<>();

        expositores.add(
                new Expositor.Builder()
                        .codigo("E001")
                        .nombre("Luis Mario")
                        .apellidos("Cardenas Ramirez")
                        .sueldo(1630)
                        .correo("luis@gmail.com")
                        .build()
        );
        expositores.add(
                new Expositor.Builder()
                        .codigo("E002")
                        .nombre("Maria Sofia")
                        .apellidos("Arteaga Diaz")
                        .sueldo(1400)
                        .correo("maria@gmail.com")
                        .build()
        );
        expositores.add(
                new Expositor.Builder()
                        .codigo("E003")
                        .nombre("Fernando Luis")
                        .apellidos("Perez Mecca")
                        .sueldo(1330)
                        .correo("fernando@gmail.com")
                        .build()
        );
        expositores.add(
                new Expositor.Builder()
                        .codigo("E004")
                        .nombre("Lorena Rosa")
                        .apellidos("Manrique Ramirez")
                        .sueldo(1500)
                        .correo("lorena@gmail.com")
                        .build()
        );
        expositores.add(
                new Expositor.Builder()
                        .codigo("E005")
                        .nombre("Alexandra Roxana")
                        .apellidos("Riva Mariategui")
                        .sueldo(1630)
                        .correo("alexandra@gmail.com")
                        .build()
        );
        expositores.add(
                new Expositor.Builder()
                        .codigo("E006")
                        .nombre("Marcos Jose")
                        .apellidos("Paz Riquez")
                        .sueldo(1200)
                        .correo("marcos@gmail.com")
                        .build()
        );
        return expositores;
    }
}
