
package gesical_g02;

import java.util.ArrayList;


public abstract class Musico {
    private String genero;
    private int anioDeLanzamientoProfesion;
    private String discografica;
    public ArrayList <Disco> discos;;

    public Musico(String genero, int anioDeLanzamientoProfesion, String discografica, ArrayList<Disco> discos) {
        this.genero = genero;
        this.anioDeLanzamientoProfesion = anioDeLanzamientoProfesion;
        this.discografica = discografica;
        this.discos = discos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioDeLanzamientoProfesion() {
        return anioDeLanzamientoProfesion;
    }

    public void setAnioDeLanzamientoProfesion(int anioDeLanzamientoProfesion) {
        this.anioDeLanzamientoProfesion = anioDeLanzamientoProfesion;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public ArrayList<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(ArrayList<Disco> discos) {
        this.discos = discos;
    }

    
    
}
