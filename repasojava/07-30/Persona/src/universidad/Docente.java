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
public class Docente extends Persona{
    int cargaHoraria;

    public Docente(int cargaHoraria, String nombres, String apellidos, String numeroDocumento, Sexo sexo) {
        super(nombres, apellidos, numeroDocumento, sexo);
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

 
    
    
}
