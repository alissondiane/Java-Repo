package com.arteaga.practica03.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tabla;
    private Long idRegistro;
    private Date fecha;
    private String usuario;
    private String tipo;

    public Auditoria() {
    }

    public Auditoria(String tabla, Long idRegistro, Date fecha,
                     String usuario, String tipo) {
        super();
        this.tabla = tabla;
        this.idRegistro = idRegistro;
        this.fecha = fecha;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Auditoria [id=" + id + ", tabla=" + tabla + ", idRegistro="
                + idRegistro + ", fecha=" + fecha + ", usuario=" + usuario
                + ", tipo=" + tipo + "]";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTabla() {
        return tabla;
    }
    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    public Long getIdRegistro() {
        return idRegistro;
    }
    public void setIdRegistro(Long idRegistro) {
        this.idRegistro = idRegistro;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
