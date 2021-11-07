/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clase.Estudiante;

/**
 *
 * @author Hermes
 */
public class Arreglo {
    
    public static ArrayList<Estudiante>lista = new ArrayList();
    
    public void Exito(){
        try {
            JOptionPane.showMessageDialog(null, "SE INGRESO CORRECTAMENTE");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATO");
        }
        
    }
    
    public void Buscar(int Codigo){
        
//        for(int i=0; i<=lista.size();i++){
//            if (lista.get(i).getCodigo() == Codigo){
//                JOptionPane.showMessageDialog(null, "CODIGO ENCONTRADO");
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "CODIGO NO EXISTE");
//            }
//            
//        }
    }

}
