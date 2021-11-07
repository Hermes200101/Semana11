/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clase.Estudiante;
import archivos.Nuevo;
import static archivos.Nuevo.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Hermes
 */
public class Arreglo {
    
    public static ArrayList<Estudiante>lista = new ArrayList();
    Estudiante e = new Estudiante();

    
    
    public void Exito(){
        try {
            JOptionPane.showMessageDialog(null, "SE INGRESO CORRECTAMENTE");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATO");
        }
        
    }
    
    
    public void Guardar(){
       e.setCodigo(Integer.parseInt(txtCodigo.getText()));
       e.setNombre(txtNombres.getText());
       e.setApellidos(txtApellidos.getText());
       e.setTelefono(txtTelefono.getText());
       e.setSemestre(Integer.parseInt(txtSemestre.getText()));
       lista.add(e);
    }
    
    
    public void guardarDatos(Estudiante estudiante){
        try {
            FileWriter fw = new FileWriter("Estudiantes.dat",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(","+e.getCodigo());
            pw.print(","+e.getNombre());
            pw.print(","+e.getApellidos());
            pw.print(","+e.getTelefono());
            pw.print(","+e.getSemestre());
            pw.close();
            
        } catch (Exception e) {
        }
        
    }

}
