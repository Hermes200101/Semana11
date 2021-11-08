/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Clase.Estudiante;
import static archivos.Edicion.*;
import static archivos.Lista.TablaLista;
import archivos.Nuevo;
import static archivos.Nuevo.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hermes
 */
public class Arreglo {

    public static ArrayList<Estudiante> lista = new ArrayList();
    Estudiante e = new Estudiante();
    DefaultTableModel tabla = new DefaultTableModel();
    DefaultListModel listaaa = new DefaultListModel();

    public void Exito() {
        try {
            JOptionPane.showMessageDialog(null, "SE INGRESO CORRECTAMENTE");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR DATO");
        }

    }

    public void Guardar() {
        e.setCodigo(Integer.parseInt(txtCodigo.getText()));
        e.setNombre(txtNombres.getText());
        e.setApellidos(txtApellidos.getText());
        e.setTelefono(txtTelefono.getText());
        e.setSemestre(Integer.parseInt(txtSemestre.getText()));
        lista.add(e);
    }

    public void guardarDatos(Estudiante estudiante) {
        try {
            FileWriter fw = new FileWriter("Estudiantes.dat", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print("" + e.getCodigo());
            pw.print("," + e.getNombre());
            pw.print("," + e.getApellidos());
            pw.print("," + e.getTelefono());
            pw.print("" + e.getSemestre());
            pw.print("\n");
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "LLORELO :(");
        }

    }

    public void limpiezaCasillas() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtSemestre.setText("");

    }

    public void llenado() throws FileNotFoundException {

//        tabla.addColumn("CÓDIGO");
//        tabla.addColumn("NOMBRES");
//        tabla.addColumn("APELLIDOS");
//        tabla.addColumn("TÉLEFONO");
//        tabla.addColumn("SMTR");
//        TablaLista.setModel(tabla);
//        lista.add(e);

DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("APELLIDOS");
        dt.addColumn("TELEFONO");
        dt.addColumn("SEMESTRE");
        
        //FileReader fr = new FileReader("Estudiantes.dat");
        //TablaLista.setDefaultRenderer("Estudiantes.dat");
        Object fila[] = new Object[dt.getColumnCount()];
        for(int i = 0; i < lista.size(); i++){
            e = lista.get(i);
            fila[0] = e.getCodigo();
            fila[1] = e.getNombre();
            fila[2] = e.getApellidos();
            fila[3] = e.getTelefono();
            fila[3] = e.getSemestre();
            dt.addRow(fila);
        }
        TablaLista.setModel(dt);
        TablaLista.setRowHeight(60);
    

    }


    public void guardarDatos3() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter("Estudiantes.dat");
            pw = new PrintWriter(fw);

            for (int i = 0; i < lista.size(); i++) {
                e = lista.get(i);
                pw.println(String.valueOf(e.getCodigo() + ", " + e.getNombre() + ", " + e.getApellidos() + ", " + e.getTelefono()+", "+e.getSemestre()));
            }
            pw.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR DATOS");

        }
    }
    
    public void cargar_txt(){
        File ruta = new File("Estudiantes.dat");
        try{
            
            FileReader fi = new FileReader(ruta);
            BufferedReader bu = new BufferedReader(fi);
            
            
            String linea = null;
            while((linea = bu.readLine())!=null){
                StringTokenizer st = new StringTokenizer(linea, ",");
                e = new Producto();
                e.setCodigo(Integer.parseInt(st.nextToken()));
                e.setNombre(st.nextToken());
                e.setPrecio(Double.parseDouble(st.nextToken()));
                e.setDescripcion(st.nextToken());
                lista.add(e);
            }
            bu.close();
        }catch(Exception ex){
            mensaje("Error al cargar archivo: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    
}
