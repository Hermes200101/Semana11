/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

/**
 *
 * @author Hermes
 */
public class Metodos {
    Arreglo v = new Arreglo();
    
     public void eliminarRegistro(int i){
        v.vector.remove(i);
    }
     
     public int buscaCodigo(int codigo){
        for(int i = 0; i < v.vector.size(); i++){
            if(codigo == obtenerRegistro(i).getCodigo())return i;
        }
        return -1;
    }
     
     public Estudiante obtenerRegistro(int i){
        return (Estudiante)v.vector.get(i);
    }
}
