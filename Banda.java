
package gesical_g02;
import java.util.*;

public class Banda extends Musico {
    private String titulo;
    public ArrayList <Solista> solistas;

    public Banda(String titulo, ArrayList<Solista> solistas, String genero, int anioDeLanzamientoProfesion, String discografica, ArrayList<Disco> discos) {
        super(genero, anioDeLanzamientoProfesion, discografica, discos);
        this.titulo = titulo;
        this.solistas = solistas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Solista> getSolistas() {
        return solistas;
    }

    public void setSolistas(ArrayList<Solista> solistas) {
        this.solistas = solistas;
    }

    @Override
    public ArrayList<Disco> getDiscos() {
        return discos;
    }

    @Override
    public void setDiscos(ArrayList<Disco> discos) {
        this.discos = discos;
    }

    

  
    
   
}
