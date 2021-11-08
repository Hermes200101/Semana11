/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import archivos.Edicion;
import static archivos.Edicion.*;
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
    public void limpiarCasillas(){
        Nuevo.txtCodigo.setText("");
        Nuevo.txtNombres.setText("");
        Nuevo.txtApellidos.setText("");
        Nuevo.txtTelefono.setText("");
        Nuevo.txtSemestre.setText("");
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
            pw.println(","+estudiante.getSemestre());
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
    
    public void buscar(){
        try {
            FileReader fr2 = new FileReader("Alumno.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            String control, controlB;
            int encontrado = 0;

            controlB = Edicion.txtConsultarCodigo.getText();

            while ((control = br2.readLine()) != null) {
                if (control.equals(controlB)) {

                    
                    String nombre = br2.readLine();
                    String apellido = br2.readLine();
                    String telefono = br2.readLine();
                    String semestre = br2.readLine();
                    
                    Edicion.txtConsultarNombres.setText(nombre);
                    Edicion.txtConsultarApellidos.setText(apellido);
                    Edicion.txtConsultarTelefono.setText(telefono);
                    Edicion.txtConsultarSemestre.setText(semestre);
                    
                    encontrado++;
                    
                }
            }
            if(encontrado ==0){
                JOptionPane.showMessageDialog(null, "El alumno no se encontro");
            }
            br2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        
    }
    
    public void Consultar(){
    try {
            int codigo = leerCodigo();
            if(vector.buscar(codigo)!=null){
                txtNombre.setText(ap.buscar(codigo).getNombre());
                txtApellidos.setText(ap.buscar(codigo).getApellidos());
                txtDireccion.setText(ap.buscar(codigo).getDireccion());
                txtLugar.setText(ap.buscar(codigo).getLugar());
                txtMotivoDeConsulta.setText(ap.buscar(codigo).getMotivoConsulta());
                txtMedico.setText(ap.buscar(codigo).getMedico());
                txtFecha.setText(ap.buscar(codigo).getFecha());
                txtSexo.setText(ap.buscar(codigo).getSexo());
            }else{
                mensaje("¡EL CÓDIGO NO EXISTE!");
                txtCodigo.requestFocus();
            }          
        } catch (Exception e) {
            mensaje("INGRESE UN CÓDIGO VÁLIDO");
            txtCodigo.requestFocus();
        }
        
    }    
    
     public Estudiante buscar(int codigo){///PARA BUSCAR POR CODIGO
        for(int i = 0; i < vector.size(); i++){
            if (vector.get(i).getCodigo()==codigo){
                return vector.get(codigo);
            }         
        }return null;    
    }
    
    int leerCodigo(){
       return Integer.parseInt(txtConsultarCodigo.getText().trim());
   }
    
}
