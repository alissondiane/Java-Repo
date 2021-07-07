package com.arteaga.dao.impl;

import com.arteaga.beans.Categoria;
import com.arteaga.beans.Evento;
import com.arteaga.dao.EventoDao;
import com.arteaga.util.EventoOrdenPorFechaAsc;
import com.arteaga.util.EventoOrdenPorFechaDesc;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.arteaga.util.Util.*;

public class EventoDaoFile implements EventoDao {

    private List<Evento> lEvento;
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    public EventoDaoFile() {
        lEvento = new ArrayList<>();
    }

    @Override
    public void create(Evento t) {
        if(find(t.getId())==null){
            lEvento.add(t);
            grabarEventos();
        }
    }

    @Override
    public Evento find(Object id) {
        leerEventos();
        for(Evento evento:lEvento){
            if(evento.getId()==(int)id)
                return evento;
        }
        return null;
    }

    @Override
    public List<Evento> findAll() {
        leerEventos();
        return lEvento;
    }

    @Override
    public void update(Evento t) {
        for(int ind=0; ind<lEvento.size(); ind++){
            if(lEvento.get(ind).getId()==t.getId()){
                lEvento.set(ind,t);
                grabarEventos();
                break;
            }
        }
    }

    @Override
    public void delete(Object id) {
        lEvento.remove(find(id));
        grabarEventos();
    }

    private void grabarEventos(){
        String linea;
        try (BufferedWriter bufOutput = new BufferedWriter(new FileWriter("eventos.txt"))) {
            for(Evento evento:lEvento){
                linea = evento.getId()+","+evento.getNombre()+","+
                        evento.getDireccion()+","+
                        evento.getFecha()+","+
                        evento.getCapacidad()+","+evento.getCategoria()+","+
                        evento.getCosto();
                bufOutput.write(linea);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("[grabar]Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo grabar alumno.txt: " + e);
        }
    }

    private void leerEventos(){
        try (BufferedReader bufInput = new BufferedReader(new FileReader("eventos.txt"))) {
            String linea;
            lEvento.clear();
            Evento evento;
            while ((linea = bufInput.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea,",");
                evento = new Evento();
                evento.setId(Integer.parseInt(tokens.nextToken().trim()));
                evento.setNombre(tokens.nextToken().trim());
                evento.setDireccion(tokens.nextToken().trim());

                String strfecha = tokens.nextToken().trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                evento.setFecha(LocalDate.parse(strfecha,formatter));

                evento.setCapacidad(Integer.parseInt((tokens.nextToken().trim())));
                String strcategoria=tokens.nextToken().trim();

                if(strcategoria.equals(GOLD)){
                    evento.setCategoria(Categoria.GOLD);
                }else{
                    if(strcategoria.equals(PLATINUM)){
                        evento.setCategoria(Categoria.PLATINUM);
                    }else{
                        if(strcategoria.equals(SILVER)){
                            evento.setCategoria(Categoria.SILVER);
                        }
                    }
                }
                evento.setCosto(Double.parseDouble(tokens.nextToken().trim()));
                lEvento.add(evento);
            }
        } catch (FileNotFoundException f) {
            System.out.println("[leer]Archivo no encontrado: " + f);
        } catch (IOException e) {
            System.out.println("No se pudeo leer alumno.txt: " + e);
        }
    }


    @Override
    public List<Evento> orderByFechaDesc() {
        leerEventos();
        Comparator<Evento> sortFechaDesc = new EventoOrdenPorFechaDesc();
        Collections.sort(lEvento, sortFechaDesc);
        return lEvento;
    }

    @Override
    public List<Evento> orderByFechaAsc() {
        leerEventos();
        Comparator<Evento> sortFechaAsc = new EventoOrdenPorFechaAsc();
        Collections.sort(lEvento, sortFechaAsc);
        return lEvento;
    }

    @Override
    public List<Evento> filterByRangoFecha(LocalDate desde, LocalDate hasta) {
        leerEventos();
        List<Evento> listEventos = new ArrayList<>();
        for(Evento evento: lEvento){
            if (desde.compareTo(evento.getFecha()) <= 0 &&
                    hasta.compareTo(evento.getFecha()) >= 0) {
                listEventos.add(evento);
            }
        }
        return listEventos;
    }

    @Override
    public void visualizarPorDetalle() {
        leerEventos();
        formatter = DateTimeFormatter.ofPattern("MMMM dd");

        lEvento.forEach(

                e -> System.out.println("Nombre:"+"\t"+e.getNombre()+"\t"+
                        "Fecha:"+"\t"+e.getFecha().format(formatter)+"\t"+
                        "Dia de semana:"+"\t"+e.getFecha().getDayOfWeek()+"\t"+
                        "Capacidad:"+"\t"+e.getCapacidad())
        );

    }
}
