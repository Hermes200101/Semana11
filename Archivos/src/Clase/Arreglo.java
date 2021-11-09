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
    Metodos m = new Metodos();
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

    public void limpiezaCasillas() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtSemestre.setText("");

    }

    public void llenado() {

        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("APELLIDOS");
        dt.addColumn("TELEFONO");
        dt.addColumn("SEMESTRE");
        
        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            e = lista.get(i);
            fila[0] = e.getCodigo();
            fila[1] = e.getNombre();
            fila[2] = e.getApellidos();
            fila[3] = e.getTelefono();
            fila[3] = e.getSemestre();
            dt.addRow(fila);
        }
        TablaLista.setModel(dt);

    }

    public void guardarDatos3() {
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter("Estudiantes.dat");
            pw = new PrintWriter(fw);

            for (int i = 0; i < lista.size(); i++) {
                e = lista.get(i);
                pw.println(String.valueOf(e.getCodigo() + ", " + e.getNombre() + ", " + e.getApellidos() + ", " + e.getTelefono() + ", " + e.getSemestre()));
            }
            pw.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR DATOS");

        }
    }

    public int leerCodigo() {
        try {
            int codigo = Integer.parseInt(txtConsultarCodigo.getText().trim());
            return codigo;
        } catch (Exception ex) {
            return -666;
        }
    }
}
