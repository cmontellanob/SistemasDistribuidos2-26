/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universidad;

import persona.Persona;
import persona.Sexo;

/**
 *
 * @author Dell
 */
public class Estudiante extends Persona{
    
    String cu;
    Carrera carrera;
    Materia[] listaMaterias;

    public Estudiante(String nombres, String apellidos, String numeroDocumento, Sexo sexo) {
        super(nombres, apellidos, numeroDocumento, sexo);
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Materia[] getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(Materia[] listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    
}
