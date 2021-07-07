package com.arteaga.threads;

import com.arteaga.beans.Evento;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

public class CopiaSeguridad extends Thread{


    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    private List<Evento> eventos;

        @Override
        public void run(){
            try {
                for (int i = 0; i < 6; i++) {
                    copyFile();
                    sleep(10000);
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }

        private void copyFile(){

            File directorio = new File("C:/eventos/");

            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }

            String nombre = LocalDateTime.now().toString();
            nombre = "copia_seguridad_"+nombre.replace(":","_")+".txt";

            String linea;
            try (BufferedWriter bufOutput = new BufferedWriter(new FileWriter("C:/eventos/"+nombre))) {
                for(Evento evento:eventos){
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
                System.out.println("No se pudeo grabar copia de seguridad de eventos.txt: " + e);
            }
        }
}
