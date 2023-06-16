
package gesical_g02;

import java.util.ArrayList;


public class Solista extends Musico implements Cloneable{
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Boolean tocaInstrumento;
    public Instrumento instrumento;
    private Boolean esCantante;

    public Solista(String nombre, String apellido, String nacionalidad, Boolean tocaInstrumento, Instrumento instrumento, Boolean esCantante, String genero, int anioDeLanzamientoProfesion, String discografica, ArrayList<Disco> discos) {
        super(genero, anioDeLanzamientoProfesion, discografica, discos);
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.tocaInstrumento = tocaInstrumento;
        this.instrumento = instrumento;
        this.esCantante = esCantante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getTocaInstrumento() {
        return tocaInstrumento;
    }

    public void setTocaInstrumento(Boolean tocaInstrumento) {
        this.tocaInstrumento = tocaInstrumento;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Boolean getEsCantante() {
        return esCantante;
    }

    public void setEsCantante(Boolean esCantante) {
        this.esCantante = esCantante;
    }

    @Override
    public ArrayList<Disco> getDiscos() {
        return discos;
    }

    @Override
    public void setDiscos(ArrayList<Disco> discos) {
        this.discos = discos;
    }

    @Override
    public String toString() {
        return " " + nombre + " ";
    }
    

   
}
