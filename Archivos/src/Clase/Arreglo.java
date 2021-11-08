/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import archivos.Nuevo;
import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Arreglo {

    Vector vector = new Vector();
    
    public void datos(){
        Estudiante.setCodigo(Integer.parseInt(Nuevo.txtCodigo.getText()));
        Estudiante.setNombre(Nuevo.txtNombres.getText());
        Estudiante.setApellidos(Nuevo.txtApellidos.getText());
        Estudiante.setTelefono(Nuevo.txtTelefono.getText());
        Estudiante.setSemestre(Integer.parseInt(Nuevo.txtSemestre.getText()));
    }
    public void guardar(Estudiante estudiante){
        vector.addElement(estudiante);
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
            JOptionPane.showMessageDialog(null, "Alumno registrado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public DefaultTableModel tabla(){
        Vector titulo = new Vector();
        titulo.addElement("Codigo");
        titulo.addElement("Nombre");
        titulo.addElement("Apellido");
        titulo.addElement("Telefono");
        titulo.addElement("Semestre");
        
        DefaultTableModel tabla = new DefaultTableModel(titulo,0);
        
        try {
            FileReader fr = new FileReader("Alumno.txt");
            BufferedReader br = new BufferedReader(fr);
            String w;
            while((w = br.readLine())!=null){
                StringTokenizer dato = new StringTokenizer(w,",");
                Vector a = new Vector();
                while(dato.hasMoreTokens()){
                    a.addElement(dato.nextToken());
                }
                tabla.addRow(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return tabla;
        
    }
    
}
