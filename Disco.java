package gesical_g02;

import java.util.ArrayList;
import java.util.HashSet;


public class Disco {
   private int anio; 
   private String titulo; 
   public HashSet<Cancion> canciones;

    public Disco(int anio, String titulo, HashSet<Cancion> canciones) {
        this.anio = anio;
        this.titulo = titulo;
        this.canciones = canciones;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public HashSet<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(HashSet<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void incorporarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }
    public void eliminarCancion(Cancion cancion) {
        this.canciones.remove(cancion);
    }
     
   

}
