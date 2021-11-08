/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.io.*;
import java.nio.Buffer;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Arreglo {

    Vector vector = new Vector();
    
    public void guardar(String alumno){
        vector.addElement(alumno);
    }
    
    public void guardarArchivo(Estudiante estudiante){
        try {
            FileWriter fw = new FileWriter("Alumno.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(estudiante.getCodigo());
            pw.print(","+estudiante.getNombre());
            pw.print(","+estudiante.getApellidos());
            pw.print(","+estudiante.getTelefono());
            pw.print(","+estudiante.getSemestre());
            pw.close();         
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
